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
        holder.itemBinding.textViewTitle.text = note.title
//        holder.itemBinding.textViewDate.text = note.createdData
        holder.itemBinding.textViewDescription.text = note.description
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun setNoteList(notesList: List<Note>) {
        this.notesList = notesList.toMutableList()
        notifyDataSetChanged()
    }
}