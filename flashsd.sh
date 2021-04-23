#!/bin/bash

if [ "$EUID" -ne 0 ]
  then echo "Please run as root"
  exit
fi

read -p "Enter the disk name (ex. sdb): " diskname

umount /dev/"$diskname"1
umount /dev/"$diskname"2

(
echo d
echo 1
echo d
echo n
echo p
echo 1
echo
echo
echo w
) | fdisk /dev/$diskname

sleep 2
partprobe /dev/"$diskname"
sleep 3
mkfs.vfat -F 32 /dev/"$diskname"1

cd ./poky/build-bbb/tmp/deploy/images/beaglebone-yocto/
dd if=core-image-base-beaglebone-yocto.wic of=/dev/sdb status=progress bs=1M
