#!/bin/bash

path="https://telventgs.com/mantis/view.php?id="
path=$path$1 
echo "$path"
file=$1".txt"
wget --no-check-certificate --load-cookies cookies.txt -p $path 
