package com.reboot16.notes.services.implementation;

import com.reboot16.notes.Exception.ResourceNotFoundException;
import com.reboot16.notes.model.ErrorCode;
import com.reboot16.notes.model.entity.Notes;
import com.reboot16.notes.repositories.NotesRepository;
import com.reboot16.notes.repositories.UserRepository;
import com.reboot16.notes.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImplementation implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public Notes getNoteById(String notesId) {
        if(!notesRepository.existsByNotesId(notesId)){
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage());
        }
        return notesRepository.findByNotesId(notesId);
    }

    @Override
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    @Override
    public List<Notes> getNotesByTitle(String title) {
        return notesRepository.findAllByTitleContaining(title);
    }

    @Override
    public Notes createNotes(Notes notes) {
        String userId = notes.getUserId();
        if(!userRepository.existsByUserId(userId)){
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }
        return notesRepository.save(notes);
    }

    @Override
    public Notes updateNotesById(String notesId, Notes notesReq) {
        Notes notes = notesRepository.findByNotesId(notesId);
        if(notes == null) {
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }

        notes.setTitle(notesReq.getTitle());
        notes.setDate(notesReq.getDate());
        notes.setDescription(notesReq.getDescription());
        notes.setColorCode(notesReq.getColorCode());
        notes.setTagsList(notesReq.getTagsList());

        return notesRepository.save(notes);
    }

    @Override
    public Boolean deleteNotesById(String notesId) {
        Notes notes = notesRepository.findByNotesId(notesId);
        if(notes == null) {
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }

        notesRepository.deleteByNotesId(notesId);
        return true;
    }
}
