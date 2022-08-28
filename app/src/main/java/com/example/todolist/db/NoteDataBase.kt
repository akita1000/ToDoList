package com.example.todolist.db

import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}