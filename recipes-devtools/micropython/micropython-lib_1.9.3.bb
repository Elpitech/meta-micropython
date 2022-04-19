DESCRIPTION = "Core Python libraries ported to MicroPython"
HOMEPAGE = "https://github.com/micropython/micropython-lib"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b4c9cf84e44b0961b744ae0ca6617ae6"

inherit autotools-brokensep

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " git://github.com/micropython/micropython-lib.git;name=src;protocol=http;tag=v${PV} "

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "micropython"
RDEPENDS:${PN}-native = "micropython-native"

do_compile() {
	:
}

do_configure() {
	:
}

do_install() {
	oe_runmake -C ${S} PREFIX=${B} install	
	install -d ${D}${libdir}/micropython
	cp -r --preserve=mode,links ${B}/* ${D}${libdir}/micropython/
}

FILES:${PN} = " \
	${libdir}/micropython/* \
"

BBCLASSEXTEND = "native"
