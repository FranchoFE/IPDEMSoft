import sys
import sendMail

def readLog(file):
    infile = open(file, 'r')

    i = 0
    total = ""
    for line in infile:
        total = total + line
        i = i + 1
        if i == 7:
            break

    infile.close()
    sendMail.send_email ("franchofelez@gmail.com", "BackupLog", total)

# readLog (str(sys.argv[1]))
