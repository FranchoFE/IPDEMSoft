import serial
import socket
import sys

arduino = serial.Serial(sys.argv[1], 9600)
s = socket.socket()
port = 11111

s.bind(('', port))

s.listen(5)

saliendo=False
while saliendo==False:
   c, addr = s.accept()
   data=c.recv(1024)
   print ('Client Connected. Address:',addr,'Data:',data)

   if data=='q':
      print ('Saliendo...')
      saliendo=True
   else:
      print ('Writing data to Arduino', data)
      arduino.write(data)

   c.send(str('Ok'))
   c.close()

s.close()
arduino.close() #Finalizamos la comunicacion

