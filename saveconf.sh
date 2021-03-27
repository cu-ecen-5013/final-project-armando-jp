#!/bin/sh

# This shell script saves the target build directorie's "conf" directory to the
# root of the final-project git directory.
# Usage: make changes to files in "poky/build-bbb/conf" then run this script
#        from the root of final-project

echo "Saving conf directory to final-project root"

# check if the output directory exists, if not, make it.
if [ ! -d "./conf-backup" ]
then
    mkdir ./conf-backup
fi

# copy the contents from our build directory to our backup directory
cp -R ./poky/build-bbb/conf/* ./conf-backup
echo "Copy success"
