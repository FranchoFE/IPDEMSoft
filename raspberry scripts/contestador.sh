#!/bin/bash

logFile=~/.contestador.log  
echo `date` " " $* >> $logFile
comando1=$(echo "$1" | tr "[:lower:]" "[:upper:]") 
comando2=$(echo "$2" | tr "[:lower:]" "[:upper:]")
case $comando1 in
	ESPACIO)
		echo "El sistema tiene libre `df -h | grep rootfs | awk '{ print $4,$5 }'`"
	;;
	HOLA)
		echo "Hola. Como estas?"
	;;
	TOP)
		echo "`ps -e -o pcpu,state,args --sort pcpu | tail -n 5`" 
	;;
	BUENOS)
		if [ $comando2 = DIAS ]; then
			echo "`clima.sh`"
		else
			echo "\"$*\" no lo entiendo"
		fi	
	;;	
	PARTIDO)
		echo "`proximoPartido.sh`"
	;;
	PESO)
		echo "`registraPeso.sh $comando2`"
	;;
	COPIAHD)
		echo `copiaHD.sh`
	;;
	COPIASD)
		echo `copiaSD.sh`
	;;
	*)
		#echo "\"$*\" no lo entiendo"
;;
esac
