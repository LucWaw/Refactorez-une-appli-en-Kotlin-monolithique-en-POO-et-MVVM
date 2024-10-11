package com.openclassrooms.notes.repository

import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class NotesRepositoryTest {

    @Mock
    private lateinit var mockNotesApiService: NotesApiService


    @Mock
    lateinit var notesRepository: NotesRepository

    @Before
    fun setUp() {
        notesRepository = NotesRepository(mockNotesApiService)
    }

    @Test
    fun getNotes() = runTest {
        //Arrange
        val mockNotes = listOf(
            Note("Test Title 1", "Test Content 1"),
            Note("Test Title 2", "Test Content 2")
        )

        // Configurer le mock pour retourner la liste de notes
        whenever(mockNotesApiService.getAllNotes()).thenReturn(mockNotes)

        //Act
        val notesFlow = notesRepository.notes
        val notes = notesFlow.first()


        //Assert
        assertEquals(notes, mockNotes)
        Mockito.verify(mockNotesApiService).getAllNotes()
    }

    @Test
    fun getALotOfNotes() = runTest {
        //Arrange
        val mockNotes = listOf(
            Note("Test Title 1", "Test Content 1"),
            Note("Test Title 2", "Test Content 2"),
            Note("Test Title 1", "Test Content 1"),
            Note("Test Title 2", "Test Content 2"),
            Note("Test Title 1", "Test Content 1"),
            Note("Test Title 2", "Test Content 2"),
            Note("Test Title 1", "Test Content 1"),
            Note("Test Title 2", "Test Content 2")
        )

        // Configurer le mock pour retourner la liste de notes
        whenever(mockNotesApiService.getAllNotes()).thenReturn(mockNotes)

        //Act
        val notesFlow = notesRepository.notes
        val notes = notesFlow.first()


        //Assert
        assertEquals(notes.size, mockNotes.size)
        Mockito.verify(mockNotesApiService).getAllNotes()
    }


}