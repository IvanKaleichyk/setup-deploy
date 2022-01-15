package com.kaleichyk.plugins

import com.kaleichyk.database.databaseDriver
import com.kaleichyk.database.databasePassword
import com.kaleichyk.database.databaseUrl
import com.kaleichyk.database.databaseUser
import com.kaleichyk.database.table.NoteTable
import io.ktor.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    Database.connect(databaseUrl, databaseDriver, databaseUser, databasePassword)

    transaction {
        SchemaUtils.create(NoteTable)
    }
}
