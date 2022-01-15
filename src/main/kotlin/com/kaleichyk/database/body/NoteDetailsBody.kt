package com.kaleichyk.database.body

data class NoteDetailsBody(
    val title: String,
    val name: String,
    val body: String,
    val isPrivate: Boolean
)