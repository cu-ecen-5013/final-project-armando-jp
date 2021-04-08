#TODO: Add server-start-stop.sh to /etc/init.d/ on BBB
#TODO: Add enable-gpio-pins.sh somewhere so it can be run at boot

DESCRIPTION = "Adds files to target filesystem"
LICENSE = "CLOSED"

SRC_URI = "file://test-file.txt \
		file://server-start-stop.sh \
		file://enable-gpio-pins.sh \
		"


inherit allarch
do_compile[noexec] = "1"

INITSCRIPT_PACKAGES = "${PN} ${PN}_B"
INITSCRIPT_NAME_${PN} = "server-start-stop.sh"
INITSCRIPT_PARAMS_${PN} = "defaults 99"
INITSCRIPT_NAME_${PN}_B = "enable-gpio-pins.sh"
INITSCRIPT_PARAMS_${PN}_B = "defaults 99"
inherit autotools update-rc.d

#create the folder in the target machine
#${D} is the directory of the target machine
#move the file from working directory to the target machine

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/test-file.txt ${D}${bindir}

	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -m 0755 ${WORKDIR}/server-start-stop.sh ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/enable-gpio-pins.sh ${D}${sysconfdir}/init.d
	#update-rc.d server-start-stop.sh defaults
	#update-rc.d enable-gpio-pins.sh defaults

	chmod a+x ${D}${sysconfdir}/init.d/server-start-stop.sh
    chmod a+x ${D}${sysconfdir}/init.d/enable-gpio-pins.sh

	#ln -s ${D}${sysconfdir}/init.d/server-start-stop.sh ${D}${sysconfdir}/rcS.d/S81server-start-stop.sh
	#ln -s ${D}${sysconfdir}/init.d/enable-gpio-pins.sh ${D}${sysconfdir}/rcS.d/S80enable-gpio-pins.sh
}

#CONFFILES_${PN} += "${sysconfdir}/init.d/server-start-stop.sh"
#CONFFILES_${PN}_B += "${sysconfdir}/init.d/enable-gpio-pins.sh"

#FILES_${PN} += "${sysconfdir}/*"
