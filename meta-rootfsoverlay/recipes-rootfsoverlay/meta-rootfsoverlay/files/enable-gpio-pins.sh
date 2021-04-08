#!/bin/sh

#place me in /etc/init.d/
#enable pin 27 on P9 as an output and set to 1 (HIGH)

echo 115 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio115/direction
echo 1 > /sys/class/gpio/gpio115/value
