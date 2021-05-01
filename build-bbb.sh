#!/bin/bash

echo "Building Final Project"
cwd=$(pwd)
echo "Building Client"
cd ./aesd-final-project-server/client/src/

#check if directory exists already
mkdir ./obj

make
retval=$?
if [ $retval -ne 0 ]; then
    echo "Return code was not zero but $retval"
    echo "Client Build fail"
    exit
else
    echo "Client Build success"
fi

cd $cwd

echo "Building Image"
cd ./poky
source oe-init-build-env build-bbb
echo $cwd"/meta-finalprojectserver"
bitbake-layers add-layer $cwd"/meta-finalprojectserver"
bitbake-layers add-layer $cwd"/meta-rootfsoverlay"
cd ../../

rm ./poky/build-bbb/conf/local.conf #remove the current local.conf file
cp ./conf-backup/local.conf ./poky/build-bbb/conf/local.conf #copy backup local.conf
#cp ./poky/build-bbb/conf-backup ./poky/build-bbb/conf #rename the conf directory
#bitbake -c cleanall core-image-base
bitbake core-image-base

retval=$?
if [ $retval -ne 0 ]; then
    echo "Return code was not zero but $retval"
    echo "Image Build fail"
    exit
else
    echo "Build success"
fi


echo "Here"
