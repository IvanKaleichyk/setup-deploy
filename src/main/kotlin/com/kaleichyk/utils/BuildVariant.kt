package com.kaleichyk.utils

object BuildVariant {

    val buildVariantType = BuildVariantType.DEBUG
}

enum class BuildVariantType {
    DEBUG, RELEASE
}