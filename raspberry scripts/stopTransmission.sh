#!/bin/bash

/etc/init.d/transmission-daemon stop
python /usr/local/bin/sendMail.py franchofelez@gmail.com "Cerrando Transmission" "a"
