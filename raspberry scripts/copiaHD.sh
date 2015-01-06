#!/bin/bash

echo "Encendiendo HD"
python /usr/local/bin/pTCPClient.py 192.168.1.128 l
sleep 30

echo "Montando HD"
sudo mount -t exfat-fuse /dev/sdb2 /media/HDBackup/
sleep 10

echo "Copiando ficheros"
sudo mv /home/pi/torrents/complete/* /media/HDBackup/fromRaspberry/
sleep 10

echo "Desmontando HD"
sudo umount /media/HDBackup
sleep 30

echo "Apagando HD"
python /usr/local/bin/pTCPClient.py 192.168.1.128 h



