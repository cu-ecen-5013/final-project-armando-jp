#!/bin/sh

# This shell script configures GPIO 115 (GPIO3_19) and sets the output to low.

echo "Configuring GPIO"

echo 115 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio115/direction
echo 0 > /sys/class/gpio/gpio/value

echo "Configuration success"
