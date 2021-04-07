#TODO: Add server-start-stop.sh to /etc/init.d/ on BBB
#TODO: Add enable-gpio-pins.sh somewhere so it can be run at boot

DESCRIPTION = "Adds files to target filesystem"
LICENSE = "CLOSED"

SRC_URI = "file://test-file.txt"


inherit allarch
do_compile[noexec] = "1"

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "server-start-stop.sh"

#create the folder in the target machine
#${D} is the directory of the target machine
#move the file from working directory to the target machine

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/test-file.txt ${D}${bindir}

	#install -d ${D}${sysconfdir}/init.d
	#install -m 0755 ${S}/server-start-stop.sh ${D}${sysconfdir}/init.d
}
