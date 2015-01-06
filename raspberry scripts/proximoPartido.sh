#!/bin/bash

temporal=/tmp/proximoPartido
wget http://www.eldesmarque.com/sevilla-futbol-club -o $temporal.log -O $temporal

grep -A 1 "<strong>Próximo partido</strong>" $temporal | tail -n 1 | cut -d\> -f2 | cut -d\< -f1
grep -A 2 "<strong>Próximo partido</strong>" $temporal | tail -n 1 | cut -d\> -f2 | cut -d\< -f1
