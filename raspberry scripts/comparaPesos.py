#!/usr/bin/python

import sys

peso1=float(sys.argv[1])
peso2=float(sys.argv[2])

diferencia = peso1-peso2 
if peso1 > peso2:
	print ("Has engordado %.1f kg desde la ultima vez" % diferencia)
elif peso1 < peso2:
	print ("Has adelgazado %.1f kg desde la ultima vez" % -diferencia) 
else:
	print ("Estas igual que la ultima vez")

		
