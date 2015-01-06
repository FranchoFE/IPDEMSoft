#!/bin/bash

pesoFile=~/.peso.log

lastPeso=`tail -n 1 $pesoFile | cut -d\| -f3`
lastDate=`tail -n 1 $pesoFile | cut -d\| -f1`
echo "`date`|`date +%s`|$1" >> $pesoFile
python /usr/local/bin/comparaPesos.py $1 $lastPeso
echo "desde $lastDate"


