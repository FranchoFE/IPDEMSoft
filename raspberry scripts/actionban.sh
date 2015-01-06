#!/bin/bash

echo "`date` Actionban $*" >> /home/pi/.actionban.log
python /usr/local/bin/sendMail.py franchofelez@gmail.com "Baneando..." "Baneando $1 $2"
