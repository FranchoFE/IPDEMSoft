#!/bin/bash

# Demonio de contestador centerim
su pi -c 'screen -dmS centerim /usr/bin/centerim'

# Notificacion de arranque
python /usr/local/bin/sendMail.py franchofelez@gmail.com "Raspberry boot" "Arranque de Raspberry pi a las `date` `whoami`" 
