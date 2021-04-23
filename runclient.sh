#!/bin/sh

echo "Running Client"

read -p "Enter beaglebone black IPv4 address: " bbbip

cd ./aesd-final-project-server/client/bin
./client $bbbip
