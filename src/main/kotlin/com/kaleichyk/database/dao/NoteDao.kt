package com.kaleichyk.database.dao

import com.kaleichyk.data.NoteDetails
import com.kaleichyk.data.toNoteDetails
import com.kaleichyk.database.body.NoteDetailsBody
import com.kaleichyk.database.entity.NoteEntity
import com.kaleichyk.database.utils.getOffset
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

interface NoteDao {

    companion object {
        const val NOTE_DEFAULT_PAGE = 1
        const val NOTE_DEFAULT_PER_PAGE = 10
    }

    suspend fun getNotes(
        page: Int = NOTE_DEFAULT_PAGE,
        perPage: Int = NOTE_DEFAULT_PER_PAGE
    ): List<NoteDetails>

    suspend fun getNote(id: Long): NoteDetails

    suspend fun addNote(note: NoteDetailsBody): NoteDetails
}

class NoteDaoImpl : NoteDao {

    override suspend fun getNotes(page: Int, perPage: Int) = newSuspendedTransaction {
        NoteEntity.all().limit(perPage, getOffset(page, perPage)).map { it.toNoteDetails() }
    }

    override suspend fun getNote(id: Long) = newSuspendedTransaction {
        NoteEntity.findById(id)?.toNoteDetails() ?: throw NullPointerException("Cannot find user with id = $id")
    }

    override suspend fun addNote(note: NoteDetailsBody) = newSuspendedTransaction {
        NoteEntity.new {
            title = note.title
            body = note.body
            name = note.name
            isPrivate = note.isPrivate
        }.toNoteDetails()
    }
}
