package com.example.todolist.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface NoteDao : List<Note> {
    @Query("SELECT * FROM note_table")
    suspend fun getAllNotes(): List<Note>

    @Insert(onConflict = REPLACE)
    suspend fun saveDB(note: Note)

    @Update(onConflict = REPLACE)
    suspend fun updateDB(note: Note)

   @Delete
    suspend fun deleteDB(note: Note)
}