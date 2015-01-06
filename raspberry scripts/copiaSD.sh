#!/bin/bash

echo "Montando SD"
sudo mount -t vfat /dev/sda1 /media/pendrive/
sleep 10

echo "Sacando de carpetas"
sudo mv /home/pi/torrents/complete/*/*.avi /home/pi/torrents/complete/.
sudo mv /home/pi/torrents/complete/*/*.mkv /home/pi/torrents/complete/.

echo "Copiando ficheros"
sudo mv /home/pi/torrents/complete/* /media/pendrive/
sleep 10

echo "Desmontando HD"
sudo umount /media/pendrive
sleep 30




