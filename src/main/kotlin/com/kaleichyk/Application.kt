package com.kaleichyk

import com.kaleichyk.database.dao.NoteDaoImpl
import com.kaleichyk.plugins.configureDatabase
import com.kaleichyk.plugins.configureMonitoring
import com.kaleichyk.plugins.configureRouting
import com.kaleichyk.plugins.configureSerialization
import com.kaleichyk.route.configureNoteRoute
import io.ktor.application.Application
import io.ktor.routing.routing
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("UNUSED")
fun Application.module() {
    configureDatabase()
    configureRouting()
    configureMonitoring()
    configureSerialization()

    routing {
        configureNoteRoute(NoteDaoImpl())
    }
}
