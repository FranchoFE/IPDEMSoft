#!/bin/bash

logFile=/home/pi/logs/issPosition.log
url=https://api.wheretheiss.at/v1/satellites/25544

wget $url --no-check-certificate -O $logFile 2> /dev/null

latitude=`cat $logFile | cut -d, -f3 | cut -d: -f2`
echo "Latitud: $latitude"

longitude=`cat $logFile | cut -d, -f4 | cut -d: -f2`
echo "Longitude: $longitude"

distance=`python /usr/local/bin/geoDistancia.py $longitude $latitude`
echo "Distancia: $distance"
distance=`echo $distance | cut -d. -f1`

blinkValue=-  
if [ $distance -lt 10000000 ];
then
  blinkValue=1
fi
if [ $distance -lt 8000000 ];
then
  blinkValue=2
fi
if [ $distance -lt 6000000 ];
then
  blinkValue=3
fi
if [ $distance -lt 5000000 ];
then
  blinkValue=4
fi
if [ $distance -lt 4000000 ];
then
  blinkValue=5
fi
if [ $distance -lt 3000000 ];
then
  blinkValue=6
fi
if [ $distance -lt 2000000 ];
then
  blinkValue=7
fi
if [ $distance -lt 1000000 ];
then
  blinkValue=8
fi
if [ $distance -lt 500000 ];
then
  blinkValue=9
fi
if [ $distance -lt 100000 ];
then
  blinkValue=0
fi

echo "BlinkValue $blinkValue"

python /usr/local/bin/pTCPClient.py 192.168.1.128 $blinkValue
