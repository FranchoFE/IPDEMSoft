import pymssql
import sys

conn = pymssql.connect(host='VTMOS_KLEIN0', user='misnt', password='misnt', database='MISNT_PROD')
cur = conn.cursor()

cur.execute('SELECT [TABLE_NAME] FROM [MISNT_PROD].[INFORMATION_SCHEMA].[TABLES] where [table_type] = \'BASE TABLE\' and [table_schema] = \'MISNT\' order by 1')
row = cur.fetchone()
tablas = []

# Se rellenan las tablas que existen en la base de datos
while row:
    tabla = []  
    tabla.append (row[0])
    tabla.append (0)
    tabla.append (0)
    tablas.append (tabla)
    row = cur.fetchone()

# Primera Vuelta con el tamanyo de todas las tablas
for tabla in tablas:
    print "Tabla: %s" % (tabla[0])
    cur.execute("SELECT count (*) from [MISNT].[%s]" % tabla[0])
    row = cur.fetchone()
    tabla[1] = (row[0])
    print "Filas de la tabla %s %d" % (tabla[0], tabla[1])
    
print "Total de tablas = %d" % (len (tablas))

print "Pulse una tecla antes de continuar para hacer la comparativa"
ch=sys.stdin.read(1)

# Segunda Vuelta
for tabla in tablas:
    print "Tabla: %s" % (tabla[0])
    cur.execute("SELECT count (*) from [MISNT].[%s]" % tabla[0])
    row = cur.fetchone()
    tabla[2] = (row[0])

print "Tablas de distinto tamanyo:" 

# Vuelta para comparar
for tabla in tablas:
    if (tabla[1] != tabla[2]):
        print "La tabla %s ha cambiado de tamanyo de %d a %d --> %d" % (tabla[0], tabla[1], tabla[2], (tabla[2] - tabla[1]))
    
conn.close()