#!/bin/bash

# Script de busqueda de nuevos torrents
torrentsFolder=/home/pi/autoTorrent
torrentList=/home/pi/.torrentList

toFind=$torrentsFolder"/*.torrent"
encontrado=false
result="NONE"
for i in `ls $toFind`
do
	echo $i
	encontrado=false
	for j in `cat $torrentList`
	do
		echo "Comparando con $j"	
		if [ $i == $j ]; then
			echo "Encontrado $i"
			encontrado=true
			break
		fi
	done
	if ! $encontrado; then
		echo "No encontrado $i"
		result=$i
		break
	fi
done

if ! $encontrado; then
	echo "lanzando $result"
	transmission-remote --auth transmission:transmission -a $result
	echo $result >> $torrentList
fi

