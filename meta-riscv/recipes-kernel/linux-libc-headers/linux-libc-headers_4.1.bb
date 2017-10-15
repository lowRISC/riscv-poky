KORG_ARCHIVE_COMPRESSION = "xz"

require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

S = "${WORKDIR}/linux-4.6.2"

SRC_URI = "git://github.com/lowrisc/riscv-linux.git;branch=ethernet-v0.5;destsuffix=${S} \
           https://cdn.kernel.org/pub/linux/kernel/v4.x/linux-4.6.2.tar.xz;name=kernel"

SRC_URI[kernel.md5sum] = "70c4571bfb7ce7ccb14ff43b50165d43"
SRC_URI[kernel.sha256sum] = "e158f3c69da87c2ec28d0f194dbe18b05e0d0b9e1142566615cea3390bab1c6a"

SRCREV_pn-linux-libc-headers = "174f39501397a32c3d9c3220e3b55ec20c16303f"
SRCREV_pn-nativesdk-linux-libc-headers = "174f39501397a32c3d9c3220e3b55ec20c16303f"

#do_configure_prepend () {
#  mv ${S}/arch/riscv ${S}/arch/riscv64
#}
