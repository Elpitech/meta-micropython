DESCRIPTION = "MicroPython is a lean and fast implementation of the Python 3 programming language"
HOMEPAGE = "https://micropython.org"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4b02e342e2322140ca59cf5d996e487a"

inherit autotools-brokensep

INC_PR = "r1"
PR = "${INC_PR}.0"

SRC_URI = " \
		   git://github.com/micropython/micropython.git;name=src;protocol=http;tag=v${PV} \
"

S = "${WORKDIR}/git"

DEPENDS = "libffi coreutils-native python3-native"

EXTRA_OEMAKE = " \
	-C ${S}/ports/unix \
	MICROPY_USE_READLINE=0 \
	MICROPY_MPYCROSS= \
	FROZEN_MANIFEST= \
	V=1 \
	CC="${CC}" \
	LD="${LD}" \
	CROSS_COMPILE="${TARGET_PREFIX}" \
	PREFIX="/usr" \
"

do_compile() {
	oe_runmake axtls
	oe_runmake micropython
}

do_configure() {
	:
}

FILES:${PN} = " \
	${bindir}/micropython \
"

RRECOMMENDS:${PN} = "micropython-lib"

INSANE_SKIP:${PN} = "already-stripped"

BBCLASSEXTEND = "native"
