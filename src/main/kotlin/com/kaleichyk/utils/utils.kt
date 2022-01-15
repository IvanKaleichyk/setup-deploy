package com.kaleichyk.utils

import io.ktor.config.ApplicationConfig

fun ApplicationConfig.stringProperty(path: String) = property(prefix + path).getString()

private val prefix = when (BuildVariant.buildVariantType) {
    BuildVariantType.DEBUG -> "debug."
    BuildVariantType.RELEASE -> "release."
}