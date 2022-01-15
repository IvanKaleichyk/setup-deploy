package com.kaleichyk.database.table

import org.jetbrains.exposed.dao.id.LongIdTable

object NoteTable : LongIdTable() {
    private const val TITLE_LENGTH = 300
    private const val NAME_LENGTH = 100

    val name = varchar("name", NAME_LENGTH)
    val title = varchar("title", TITLE_LENGTH)
    val body = text("body")
    val isPrivate = bool("private")
}