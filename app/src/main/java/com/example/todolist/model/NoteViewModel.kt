package com.example.todolist.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.db.HelperDataBase
import com.example.todolist.db.Note
import com.example.todolist.repository.NoteRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class NoteViewModel(repository: NoteRepository) : ViewModel() {

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
//
//    suspend fun getAllNotes() {
//        job = viewModelScope.launch {
//            var list: List<Note> =
//                HelperDataBase.getDataBase(this).getNoteDao().getAllNotes()
//            listViewData.value = list
//            loadingProgressBar.value = false
//            exceptionHandler
//        }
//    }
//
//    suspend fun saveNote(note: Note) {
//        job = viewModelScope.launch {
//            var list =
//                HelperDataBase.getDataBase().getNoteDao().saveDB(note)
//            listViewData.value = list
//            loadingProgressBar.value = false
//            exceptionHandler
//        }
//    }
//
//    suspend fun update(note: Note) {
//        job = viewModelScope.launch {
//            var list =
//                HelperDataBase.getDataBase(this).getNoteDao().saveDB(note)
//            listViewData.value =
//            loadingProgressBar.value = false
//            exceptionHandler
//        }
//    }
//
//    suspend fun deleteNote(id: String) {
//        job = viewModelScope.launch {
//            var list =
//                HelperDataBase.getDataBase(this).getNoteDao().deleteDB(id)
//        }
//    }
}
