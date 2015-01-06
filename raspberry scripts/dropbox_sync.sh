#!/bin/bash
aux=/tmp/dropbox.aux
autoTorrentsDir=/home/pi/torrents/autoTorrent/
bash /usr/local/bin/dropbox_uploader.sh download toRaspberry >> $aux
for torrent in $(cat /tmp/dropbox.aux | grep DONE | grep .torrent | cut -d\" -f2)  
do
	echo $torrent
	mv /home/pi$torrent $autoTorrentsDir
	bash /usr/local/bin/dropbox_uploader.sh remove $torrent >> $aux
done
rm $aux
