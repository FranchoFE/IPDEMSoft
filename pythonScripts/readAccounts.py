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

def getAccountPointValuesBarclays (line):
    line = line[:-1]
    values = line.split(";")
    result = ()
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
            validDate = datetime.date(int(validDateString[7:11]), int(validDateString[4:6]), int(validDateString[1:3]))
            result = (name, value, date, validDate)
    return result
	
def getAccountPointValuesING (line):
    line = line[:-1]
    values = line.split(";")
    result = ()
    if len(values) == 5:
        name = values[1]
        name = name.replace(".", "")
        name = name.replace("\xff", "")
        name = name.replace("\x98", "")
        valueString = values[2]
        valueString = valueString[:-2]
        value = valueString.replace(",", "")
        value = valueString.replace(".", "")
        dateString = values[0]
        dateString = dateString.replace("/", "-")
        if len(value) > 0 and dateString != "FECHA":
            #print ("Encontrado apunte: " + line)
            date = datetime.date(int(dateString[6:10]), int(dateString[3:5]), int(dateString[0:2]))
            result = (name, value, date, date)
    return result

def readAccount(fileName, accountName, accountType):
    accountIndex = existsAccount(accountName)
    actualDate = datetime.datetime.now()
    if accountIndex != -1:
        f = open(fileName)
        existing = 0
        inserted = 0
        for line in f:
            accountPointValues = ()
            if int(accountType) == 0:
                accountPointValues = getAccountPointValuesBarclays (line)
            if int(accountType) == 1:
                accountPointValues = getAccountPointValuesING (line)

            if len(accountPointValues) > 0:
                name = accountPointValues[0]
                value = accountPointValues[1]
                date = accountPointValues[2]
                validDate = accountPointValues[3]
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

def readAccountFile():
    if len (sys.argv) > 3:
        fileName = str (sys.argv[1])
        accountName = str (sys.argv[2])
        accountType = str (sys.argv[3])
        print "Leido fichero " + fileName + " " + str(accountType)
        readAccount(fileName, accountName, accountType)

    else:
        print "Se necesitan al menos tres argumentos"

cnx = mysql.connector.connect(user='amuser', password='ampw', host='192.168.1.134', database='amdb')
cursor = cnx.cursor()
cursor2 = cnx.cursor()

readAccountFile()

cnx.commit()
cursor.close()
cursor2.close()
cnx.close()

