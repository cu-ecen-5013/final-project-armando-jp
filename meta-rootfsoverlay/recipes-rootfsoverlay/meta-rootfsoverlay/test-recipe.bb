#TODO: Make server-start-stop script the main script to initialize GPIO and start server and move on.
DESCRIPTION = "Adds files to target filesystem"
LICENSE = "CLOSED"

SRC_URI = "file://server-start-stop.sh \
		"


inherit allarch
do_compile[noexec] = "1"

FILES_${PN} = "${sysconfdir}/init.d/server-start-stop.sh"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "server-start-stop.sh"
INITSCRIPT_PARAMS_${PN} = "defaults 99"

inherit autotools update-rc.d

#create the folder in the target machine
#${D} is the directory of the target machine
#move the file from working directory to the target machine

do_install() {

	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -d ${D}${sysconfdir}/network

	install -m 0755 ${WORKDIR}/server-start-stop.sh ${D}${sysconfdir}/init.d

	chmod a+x ${D}${sysconfdir}/init.d/server-start-stop.sh
}

FILES_${PN} += "${sysconfdir}/*"
