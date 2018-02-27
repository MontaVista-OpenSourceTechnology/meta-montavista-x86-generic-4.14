MV_KERNEL_BRANCH ?= "v4.14"
MV_KERNEL_TREE ?= "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git"
MV_KERNELCACHE_BRANCH ?= "yocto-4.14"
MV_KERNELCACHE_TREE ?= "git://git.yoctoproject.org/yocto-kernel-cache"

require recipes-kernel/linux/linux-yocto.inc

SRCREV_machine ?= "${MV_KERNEL_BRANCH}"
SRCREV_meta ?= "${MV_KERNELCACHE_BRANCH}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


S = "${WORKDIR}/git"

LINUX_VERSION = "4.14.3"
PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "${MV_KERNEL_TREE};branch=${MV_KERNEL_BRANCH};name=machine \
           ${MV_KERNELCACHE_TREE};type=kmeta;name=meta;branch=${MV_KERNELCACHE_BRANCH};destsuffix=${KMETA}"
SRC_URI += "file://defconfig"

DEPENDS += "elfutils-native"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "0"
COMPATIBLE_MACHINE_x86-generic-64 = "x86-generic-64"
COMPATIBLE_MACHINE_x86-generic = "x86-generic"
COMPATIBLE_MACHINE_x86-atom-64 = "x86-atom-64"
COMPATIBLE_MACHINE_corei7-mrsv-64 = "corei7-mrsv-64"
COMPATIBLE_MACHINE_dsu-d5-64 = "dsu-d5-64"
