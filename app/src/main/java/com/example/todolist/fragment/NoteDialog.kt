package com.example.todolist.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.todolist.databinding.EditTextDialogBinding
import com.example.todolist.db.HelperDataBase
import com.example.todolist.db.Note
import com.example.todolist.db.NoteDao
import com.example.todolist.model.NoteVMFactory
import com.example.todolist.model.NoteViewModel
import com.example.todolist.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteDialog : DialogFragment() {
    private var _binding: EditTextDialogBinding? = null
    private val binding
        get() = _binding!!
    lateinit var noteViewModel: NoteViewModel

    @Override
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = EditTextDialogBinding.inflate(LayoutInflater.from(requireContext()))
        var noteDao: NoteDao = HelperDataBase.getDataBase(requireContext()).getNoteDao()
        var noteVMFactory = NoteVMFactory(NoteRepository(noteDao))
        noteViewModel = ViewModelProvider(this, noteVMFactory).get(NoteViewModel::class.java)
        
        return AlertDialog.Builder(requireContext())
            .setTitle("New notes")
            .setMessage("Enter")
            .setView(binding.root)
            .setPositiveButton("ADD") { _, _ ->
                noteViewModel.saveNote(
                    Note(
                        binding.editTextId.text.toString().toInt(),
                        binding.editTexTitle.text.toString(),
                        binding.editTextTextDesc.text.toString()
                    )
                )
            }.create()
    }
}