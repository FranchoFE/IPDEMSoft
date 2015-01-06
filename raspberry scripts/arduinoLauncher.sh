#!/bin/bash

serialPath=`ls /dev/ttyACM*`
echo $serialPath
python /usr/local/bin/pArduinoLauncher.py $serialPath
