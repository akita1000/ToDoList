package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemBinding
import com.example.todolist.db.Note

class NoteAdapter(var notesList: MutableList<Note>) : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}