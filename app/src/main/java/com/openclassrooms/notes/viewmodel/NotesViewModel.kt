package com.openclassrooms.notes.viewmodel

import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val notesRepository : NotesRepository) : ViewModel() {


    fun getNotes() = notesRepository.notes


}