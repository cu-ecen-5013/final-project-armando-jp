DESCRIPTION = "Adds files to target filesystem"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI = "file://test-file.txt"

#specify where to get the files
S = "${WORKDIR}"


#create the folder in the target machine
#${D} is the directory of the target machine
#move the file from working directory to the target machine

do_install () {
	install -d ${D}/TestFolder
	install -m 0755 ${WORKDIR}/test-file.txt ${D}/TestFolder
	cp ${S}/test-file.txt ${D}/TestFolder
}
