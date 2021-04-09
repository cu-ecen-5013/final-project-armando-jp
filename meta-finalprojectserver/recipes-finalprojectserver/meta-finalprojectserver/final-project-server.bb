# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://git@github.com/armando-jp/aesd-final-project-server.git;protocol=ssh"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "120adb2d0c3f6707a33be6db1df1d8188c393f28"

FILES_${PN} += "${bindir}/server"

S = "${WORKDIR}/git"

do_compile () {
	oe_runmake -C ${S}/server/src
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/server/src/server ${D}${bindir}
	:
}
