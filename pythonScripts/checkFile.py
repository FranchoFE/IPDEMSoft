def checkfile(fileName):
    import os.path
    if os.path.exists(fileName):
        print ("El fichero existe")
    else:
        print ("El fichero no existe")

