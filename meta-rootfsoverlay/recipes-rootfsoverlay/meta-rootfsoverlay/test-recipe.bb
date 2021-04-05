DESCRIPTION = "Adds files to target filesystem"
LICENSE = "CLOSED"

SRC_URI = "file://test-file.txt"

#FILES_${PN} += "${bindir}/TestFolder"


inherit allarch
do_compile[noexec] = "1"

#create the folder in the target machine
#${D} is the directory of the target machine
#move the file from working directory to the target machine

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/test-file.txt ${D}${bindir}
}
