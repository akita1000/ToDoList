package com.example.todolist.db

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope

object HelperDataBase {
    fun getDataBase(context: Context) = Room.databaseBuilder(context, NoteDataBase::class.java, "NoteDataBase").build()
}