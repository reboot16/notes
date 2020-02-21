package com.reboot16.notes.services;

import com.reboot16.notes.model.entity.Notes;

import java.util.List;

public interface NotesService {
    Notes getNoteById(String notesId);
    List<Notes> getAllNotes();
    List<Notes> getNotesByTitle(String title);

    Notes createNotes(Notes notes);
    Notes updateNotesById(String notesId, Notes notesReq);
    Boolean deleteNotesById(String notesId);
}
