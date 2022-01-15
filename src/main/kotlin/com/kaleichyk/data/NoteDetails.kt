package com.kaleichyk.data

import com.kaleichyk.database.entity.NoteEntity

data class NoteDetails(
    val id: Long,
    val title: String,
    val name: String,
    val body: String,
    val isPrivate: Boolean
)

fun NoteEntity.toNoteDetails() = NoteDetails(
    id.value,
    title,
    name,
    body,
    isPrivate
)
