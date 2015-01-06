#!/bin/bash

/etc/init.d/transmission-daemon start
python /usr/local/bin/sendMail.py franchofelez@gmail.com "Lanzando Transmission" "a"
