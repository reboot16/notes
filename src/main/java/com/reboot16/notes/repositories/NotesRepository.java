package com.reboot16.notes.repositories;

import com.reboot16.notes.model.entity.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotesRepository extends MongoRepository<Notes, String> {
    Notes findByNotesId(String notesId);
    List<Notes> findAllByTitleContaining(String notesId);
    Boolean existsByNotesId(String notesId);

    Boolean deleteByNotesId(String notesId);
}
