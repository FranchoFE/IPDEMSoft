#!/bin/bash

for line in `cat mantis.log`
do
	echo $line
	line2=`echo $line | cut -d, -f1`
	echo $line2
	./downloadMantis.sh $line2
done
