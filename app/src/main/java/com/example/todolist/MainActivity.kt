package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todolist.adapter.NoteAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.db.HelperDataBase
import com.example.todolist.db.Note
import com.example.todolist.db.NoteDao
import com.example.todolist.fragment.NoteDialog
import com.example.todolist.model.NoteVMFactory
import com.example.todolist.model.NoteViewModel
import com.example.todolist.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!
    private var adapter = NoteAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        val noteDao: NoteDao = HelperDataBase.getDataBase(this.baseContext).getNoteDao()
        val noteVMFactory = NoteVMFactory(NoteRepository(noteDao))
        val viewModel = ViewModelProvider(this, noteVMFactory).get(NoteViewModel::class.java)

        binding.buttonAdd.setOnClickListener {
            NoteDialog().show(supportFragmentManager, "TAG")
        }
        viewModel.listViewData.observe(this) {
            println(it)
            adapter.setNoteList(it)
        }
        viewModel.getAllNotes()
    }

//    fun saveNote(note: Note) {
//        GlobalScope.launch(Dispatchers.Main) {
//            HelperDataBase.getDataBase(this@MainActivity).getNoteDao().saveDB(note)
//            adapter.notifyDataSetChanged()
//        }
}