#!/bin/bash

torrentsDir=/home/pi/torrents/autoTorrent/
torrentsFile=/home/pi/torrents/torrents.log

FreeDiskLimit=1000000

lastCommandExecuted=`tail -n 1 $torrentsFile | cut -d\| -f2` 
echo $lastCommandExecuted

FreeDisk=$((`df | grep rootfs | awk '{ print $4 }'`))
echo "Espacio Libre=$FreeDisk"
if [ $FreeDiskLimit -gt $FreeDisk ]; then
	echo "No tengo espacio"
	if [ ! $lastCommandExecuted = "Espacio" ] && [ ! $lastCommandExecuted = "Copiando" ] && [ ! $lastCommandExecuted = "Copiado"]; then
		python /usr/local/bin/sendMail.py franchofelez@gmail.com "Torrents Management" "No Free Disk. Limite = $FreeDiskLimit; Espacio = $FreeDisk"
		echo "`date`|Espacio" >> $torrentsFile
	else
		echo "Vamos a encender el disco duro"
		#echo "`date`|Copiando" >> $torrentsFile            
		#bash /usr/local/bin/copiaHD.sh 
		#echo "`date`|Copiado" >> $torrentsFile
	fi
else
	transmissionState=`ps -AF | grep transmission | wc -l`
	echo "Transmission grep result = $transmissionState"
	if [ $lastCommandExecuted = "Downloading" ] || [ $transmissionState = "1" ]; then
		echo "No bajamos ninguno"
	else
		echo "Tenemos que bajar otra cosa"
		firstTorrent=`ls -r $torrentsDir*.torrent | tail -n 1` 
		if [ $firstTorrent ]; then	
			echo "First Torrent $firstTorrent"
			fullFirstTorrent=$firstTorrent
			fullFirstTorrentDone=$firstTorrent".done"
			echo "Full $fullFirstTorrent"
			echo "Done $fullFirstTorrentDone"
			transmission-remote --auth transmission:transmission -a $fullFirstTorrent
			sleep 5 
			mv $fullFirstTorrent $fullFirstTorrentDone 
			echo "`date`|Downloading|$fullFirstTorrent" >> $torrentsFile
			python /usr/local/bin/sendMail.py franchofelez@gmail.com "Torrents Management" "Iniciando descarga: $fullFirstTorrent"
		fi
	fi
fi

echo "Terminado"

