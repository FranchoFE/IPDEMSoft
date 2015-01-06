#!/bin/bash

/usr/local/bin/sendMessage.sh $1 $2 $3
python /usr/local/bin/sendMail.py $1 $2 $3
