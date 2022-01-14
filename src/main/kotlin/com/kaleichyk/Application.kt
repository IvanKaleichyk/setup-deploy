package com.kaleichyk

import com.kaleichyk.plugins.configureMonitoring
import com.kaleichyk.plugins.configureRouting
import com.kaleichyk.plugins.configureSerialization
import io.ktor.application.Application

@Suppress("UNUSED")
fun Application.module() {
    configureRouting()
    configureMonitoring()
    configureSerialization()
}
