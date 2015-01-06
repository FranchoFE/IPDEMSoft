#!/bin/bash

waitTime=$1

if [ $# -eq 0 ]; then 
  waitTime=60
fi

while [ 1 ]; do
  date
  bash /usr/local/bin/issPosition.sh
  echo ---------------------
  sleep $waitTime 
done

