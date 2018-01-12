FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

S = "${WORKDIR}/git"

SRC_URI += "file://defconfig"

KCONF_BSP_AUDIT_LEVEL = "0"
COMPATIBLE_MACHINE_x86-generic-64 = "x86-generic-64"
COMPATIBLE_MACHINE_x86-generic = "x86-generic"
