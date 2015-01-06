import sys
import poplib
import email
import email.feedparser

GMAIL_USER = 'franchoraspberry@gmail.com'
GMAIL_PASS = 'osijek68'
POP_SERVER = 'pop.gmail.com'
POP_PORT = 995

def show_mail():
    m = poplib.POP3_SSL(POP_SERVER, POP_PORT)
    m.user (GMAIL_USER)
    m.pass_(GMAIL_PASS)
    numero = len (m.list()[1])
    print "Numero de mensajes sin leer " + str(numero)
    for i in range (numero):
       print
       print "Mensaje " + str (i+1)
       raw = m.retr(i+1)
       parser=email.feedparser.FeedParser()
       parser.feed('\n'.join(raw[1]))
       message2=parser.close()
       subject = message2["Subject"]
       print "Subject: " + subject
       print "From: " + message2["From"]
       print "To: " + message2["To"] 
       multipart2=message2.is_multipart()
       print "Multipart " + str(multipart2)
       if (multipart2):
          parts = message2.get_payload()
          print "Parts " + str (len(parts))
          for j in range (len(parts)):
		print "Part " + str (j) + ": " + (parts[j].get_content_type()) 
		if (parts[j].get_content_type() == "text/html"):
			filename="/home/pi/VTMOSAlerts/" + subject + ".html"
              		with open(filename, 'wb') as out:
                  		out.write(parts[j].get_payload(decode=True))
    m.quit()

show_mail()

