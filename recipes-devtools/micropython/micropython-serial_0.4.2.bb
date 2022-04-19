DESCRIPTION = "pySerial-like interface for MicroPython (unix port)"
HOMEPAGE = "https://github.com/pfalcon/micropython-serial"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " \
        gitsm://github.com/pfalcon/micropython-serial.git;name=src \
"

SRCREV = "d6bd0b97d78b8a9f95c1c213ee59f0b87ae9843f"

S = "${WORKDIR}/git"

do_compile() {
	:
}

do_configure() {
	:
}

do_install() {
	install -d ${D}${libdir}/micropython
	cp -r --preserve=mode,links ${S}/serial.py ${D}${libdir}/micropython/
}

FILES:${PN} = " \
	${libdir}/micropython/serial.py \
"

RDEPENDS:${PN} = "micropython micropython-lib"

BBCLASSEXTEND = "native"
