#TCPclient.py
#!/usr/bin/python          
import sys
import socket              
 
arglen=len(sys.argv)
if arglen<3:
    print('please run as python TCPclient.py <ip_address> <numbers>')
    exit()
data=str()
data=data+str(sys.argv[2])
for i in range(3,arglen):
    data=data+':'+str(sys.argv[i])
 
s = socket.socket()        
 
port = 11111          
 
s.connect((sys.argv[1], port))
s.send(data)
print s.recv(1024)
s.close 
