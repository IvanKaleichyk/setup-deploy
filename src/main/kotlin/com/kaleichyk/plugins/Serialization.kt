package com.kaleichyk.plugins

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}
