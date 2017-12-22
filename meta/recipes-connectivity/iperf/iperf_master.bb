SUMMARY = "Iperf performance tester"
DESCRIPTION = "Iperf is a performance tester."
HOMEPAGE = "http://www.dest-unreach.org/socat/"

SECTION = "console/network"

DEPENDS = "openssl readline"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://README.md;beginline=163;endline=189;md5=0df94d8357ab725307f56f53f2248da5"


SRC_URI = "https://github.com/esnet/iperf/archive/master.zip"

SRC_URI[md5sum] = "df2cd5994bae652a0d1d455a00430c87"
SRC_URI[sha256sum] = "ccfd8093699c8e58da86f40b960951841a6b9895c4ce4521ce16869adf2536ee"

do_install () {
    mkdir -p ${D}${bindir}
    install src/iperf3 ${D}${bindir}
}

EXTRA_OEMAKE += 'noinst_PROGRAMS="" COPTS="${CFLAGS} -I${S}/include"'

do_configure () {
	./configure --host x86_64 --prefix=/usr
}

# This version of RISCV compiler does not support profiling, so edit it out ...

do_compile () {
	find . -name Makefile | xargs sed -i -e 's=-pg==g'
	oe_runmake
}

FILES_${PN} = "/usr/bin"