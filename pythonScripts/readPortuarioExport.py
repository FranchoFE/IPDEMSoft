__author__ = 'Francho'

def readFile (fileName):
    file = open(fileName)
    print ("Leido " + fileName)
    objects = list()
    object = dict()
    for line in file:
        if (line.find("<?xml version='1.0'  encoding='UTF8' ?>") == -1) and (line.find("RESULTS>") == -1) and (line.find("<ROW>") == -1):
            if line.find("</ROW>") != -1:
                objects.append (object)
                object = dict()
            else:
                att = line.split("\"")[1]
                value = line.split("[")[2]
                value = value.split("]")[0]
                object[att] = value
    print ("Total de objetos leidos = " + str(len(objects)))

readFile ("BuquesInterior.xml")
readFile ("Buques.xml")
readFile ("GruposUsuarios.xml")
readFile ("Paises.xml")