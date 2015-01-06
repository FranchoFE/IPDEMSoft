#!/bin/bash

serial=/dev/serial/by-id/usb-Arduino__www.arduino.cc__0043_75335313437351713102-if00

exec 3<> $serial
sleep 2
echo $1 >&3
echo "Cambiado color!"
