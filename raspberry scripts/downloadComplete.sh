#/bin/bash

# Script que es invocado cuando finaliza la descarga de algún torrent
torrentList=/home/pi/torrents/torrents.log

lastTorrent=`grep \|Downloading\| $torrentList | tail -n 1 | cut -d\| -f3`
python /usr/local/bin/sendMail.py franchofelez@gmail.com "Torrents Management" "Ultimo torrent: $lastTorrent"

echo "`date`|Downloaded|$lastTorrent" >> $torrentList
