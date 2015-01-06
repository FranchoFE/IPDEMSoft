#!/bin/bash

logFile=/home/pi/logs/spider.log
logFile2=/home/pi/logs/spiderLongitude.log
message='Parece que el fichero de horarios del fitin ha cambiado de longitud!!' 

oldLongitude=`cat $logFile2`
rm $logFile2
wget fitin.es/images/pdf/horarios.pdf --spider 2> $logFile
cat $logFile | grep "Longitud" | cut -d\  -f2 >> $logFile2
longitude=`cat $logFile2`
echo "Old Longitude $oldLongitude" 
echo "Longitude $longitude"

if [ $longitude = $oldLongitude ]; then
	echo "El mismo fichero"
else
	echo "Distintos ficheros"
	python /usr/local/bin/sendMail.py franchofelez@gmail.com SpiderWeb "$message" 
	python /usr/local/bin/sendMail.py jeususs@gmail.com SpiderWeb "$message" 
fi
