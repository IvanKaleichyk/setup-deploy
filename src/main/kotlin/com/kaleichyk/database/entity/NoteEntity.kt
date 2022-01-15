package com.kaleichyk.database.entity

import com.kaleichyk.database.table.NoteTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class NoteEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<NoteEntity>(NoteTable)

    var title by NoteTable.title
    var name by NoteTable.name
    var body by NoteTable.body
    var isPrivate by NoteTable.isPrivate
}
