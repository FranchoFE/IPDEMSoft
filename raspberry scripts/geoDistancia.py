#!/usr/bin/env/python
# -*- coding: utf-8

import sys 
from os import system
from math import sin,cos,sqrt,asin,pi

long1 = float(sys.argv[1]) 
lat1 = float(sys.argv[2]) 
long2 = -5.9833333 
lat2 = 37.383333 
 
long1,lat1 = (long1,lat1)
long2,lat2 = (long2,lat2)
 
r = 6371000 #radio terrestre medio, en metros
c = pi/180 #constante para transformar grados en radianes
#Fórmula de haversine
d = 2*r*asin(sqrt(sin(c*(lat2-lat1)/2)**2 + cos(c*lat1)*cos(c*lat2)*sin(c*(long2-long1)/2)**2))
 
print "%0.2f" % d
 
