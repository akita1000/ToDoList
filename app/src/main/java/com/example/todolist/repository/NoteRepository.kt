package com.example.todolist.repository

import com.example.todolist.db.Note
import com.example.todolist.db.NoteDao
import retrofit2.Response

class NoteRepository(var noteDao: NoteDao) {

    suspend fun getAllNotes() : List<Note> {
        return noteDao.getAllNotes()
    }

    suspend fun saveDB(note: Note){
        return noteDao.saveDB(note)
    }

    suspend fun updateDB(note: Note) {
        return noteDao.updateDB(note)
    }

    suspend fun deleteDB(note: Note) {
        return noteDao.deleteDB(note)
    }
}
