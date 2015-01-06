#TCPserver.py
#!/usr/bin/python          
 
import socket              
 
s = socket.socket()        
port = 11111  
             
s.bind(('', port))        
 
s.listen(5)  
               
while True:
   c, addr = s.accept()
   data=c.recv(1024)    
   print ('Client Connected. Address:',addr,'Data:',data)
   
   mylist=list(data.split(':'))
   intlist=list()
   for i in range(0,len(mylist)):
       intlist.append(int(mylist[i]))
   intlist.sort()
   c.send(str('Ok'))
   c.close()
