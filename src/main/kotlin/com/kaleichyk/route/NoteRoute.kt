package com.kaleichyk.route

import com.kaleichyk.database.body.NoteDetailsBody
import com.kaleichyk.database.dao.NoteDao
import com.kaleichyk.database.dao.NoteDao.Companion.NOTE_DEFAULT_PAGE
import com.kaleichyk.database.dao.NoteDao.Companion.NOTE_DEFAULT_PER_PAGE
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.configureNoteRoute(dao: NoteDao) {
    route("note") {
        get {
            val page: Int
            val perPage: Int

            call.request.queryParameters.run {
                page = this["page"]?.toInt() ?: NOTE_DEFAULT_PAGE
                perPage = this["per_page"]?.toInt() ?: NOTE_DEFAULT_PER_PAGE
                val response = dao.getNotes(page, perPage)
                call.respond(response)
            }
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toLong() ?: -1
            val response = dao.getNote(id)
            call.respond(response)
        }

        post { noteBody: NoteDetailsBody ->
            val response = dao.addNote(noteBody)
            call.respond(response)
        }
    }
}