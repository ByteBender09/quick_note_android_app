package com.example.quicknote.feature_note.domain.use_case

import com.example.quicknote.feature_note.domain.model.InvalidNoteException
import com.example.quicknote.feature_note.domain.model.Note
import com.example.quicknote.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("The title of note can't be empty")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of note can't be empty")
        }
        repository.insertNode(note)
    }
}