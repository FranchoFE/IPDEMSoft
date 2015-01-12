import mysql.connector
import datetime
import sys

query = "SELECT pointId, Concept, insertDate, value, accountID FROM am_point WHERE (Concept = %s AND NOT (insertDate = %s) AND value = %s AND accountId = %s)"
queryAccount = "SELECT id FROM am_accounts WHERE name = %s"
insertPointSQL = "INSERT INTO am_point (Concept, value, date, validDate, accountId, insertDate) VALUES (%s, %s, %s, %s, %s, %s)"

def insertPoint(name, value, date, validDate, accountIndex, insertDate):
    params = (name, value, date, validDate, accountIndex, insertDate)
    #print ("InsertPoint " + str(params))
    cursor2.execute(insertPointSQL, params)

def existsAccount(accountName):
    params = (accountName,)
    result = -1
    test = cursor.execute(queryAccount, params)
    row = cursor.fetchone()
    while row is not None:
        print "Encontrada cuenta " + accountName + " con indice " + str(row[0])
        result = int (row[0])
        row = cursor.fetchone()
    return result

def existsPoint(name, insertDate, value, accountIndex):
    params = (name, insertDate, value, accountIndex)
    #print ("ExitsPoint " + str(params))
    result = 0
    test = cursor.execute(query, params)
    row = cursor.fetchone()
    while row is not None:
        result = 1
        #print (str(row))
        row = cursor.fetchone()
    return result


def readAccount(fileName, accountName):
    accountIndex = existsAccount(accountName)
    actualDate = datetime.datetime.now()
    if accountIndex != -1:
        f = open(fileName)
        existing = 0
        inserted = 0
        for line in f:
            line = line[:-1]
            values = line.split(";")
            if len(values) == 4:
                name = values[0]
                name = name.replace(".", "")
                name = name.replace("\xff", "")
                name = name.replace("\x98", "")
                valueString = values[3]
                value = valueString.replace(",", "")
                value = valueString.replace(".", "")
                dateString = values[1]
                validDateString = values[2]
                if len(name) > 0 and len(validDateString) > 0 and name != "Concepto":
                    #print ("Encontrado apunte: " + line)
                    date = datetime.date(int(dateString[7:11]), int(dateString[4:6]), int(dateString[1:3]))
                    validDate = datetime.date(int(validDateString[7:11]), int(validDateString[4:6]),
                                              int(validDateString[1:3]))
                    result = existsPoint(name, actualDate, value, accountIndex)
                    if result == 0:
                        insertPoint(name, value, date, validDate, accountIndex, actualDate)
                        inserted = inserted + 1
                    elif result == 1:
                        print ("Cuidado el apunte ya existia: " + line)
                        existing = existing + 1
        f.close()
        print "Se han insertado " + str(inserted) + " apuntes en la cuenta " + accountName
        print "Ya existian previamente " + str(existing) + " en la cuenta " + accountName
    else:
        print "Cuenta no encontrada con nombre " + accountName

if len (sys.argv) > 2:
    cnx = mysql.connector.connect(user='amuser', password='ampw', host='192.168.1.134', database='amdb')
    cursor = cnx.cursor()
    cursor2 = cnx.cursor()

    fileName = str (sys.argv[1])
    accountName = str (sys.argv[2])
    print "Leido fichero " + fileName
    readAccount(fileName, accountName)

    cnx.commit()
    cursor.close()
    cursor2.close()
    cnx.close()

else:
    print "Se necesitan al menos dos argumentos"


