import os
import readLog
import shutil

directory = "Z:/FileSyncLogs/"
ficheros = os.listdir(directory) 
bak = 0
for fichero in ficheros:
    path = os.path.join(directory, fichero)
    if os.path.isfile(path):
        print (fichero)
        readLog.readLog (path)
        shutil.move (path, directory + "old/")
    