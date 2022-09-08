package com.example.todolist.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.db.Note
import com.example.todolist.repository.NoteRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NoteViewModel(var repository: NoteRepository) : ViewModel() {

    var listViewData: MutableLiveData<List<Note>> = MutableLiveData()
    var loadingProgressBar = MutableLiveData(true)
    private var errorMessage = MutableLiveData<String>()
    private var job: Job? = null
    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable -> onError("Exception handled: ${throwable.localizedMessage}") }

    private fun onError(message: String) {
        errorMessage.value = message
        loadingProgressBar.value = false
    }

    fun getAllNotes() {
        job = viewModelScope.launch {
            var list: List<Note> =
                repository.getAllNotes()
            listViewData.value = list
            loadingProgressBar.value = false
            exceptionHandler
        }
    }

    fun saveNote(note: Note) {
        job = viewModelScope.launch {
            repository.saveDB(note)
            var list: List<Note> =
                repository.getAllNotes()
            listViewData.value = list
            loadingProgressBar.value = false
            exceptionHandler
        }
    }

    fun update(note: Note) {
        job = viewModelScope.launch {
            repository.updateDB(note)
            var list: List<Note> = repository.getAllNotes()
            listViewData.value = list
            loadingProgressBar.value = false
            exceptionHandler
        }
    }

    fun deleteNote(note: Note) {
        job = viewModelScope.launch {
            repository.deleteDB(note )
            var list: List<Note> = repository.getAllNotes()
            listViewData.value = list
            loadingProgressBar.value = false
            exceptionHandler
        }
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
