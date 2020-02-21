package com.reboot16.notes.services.implementation;

import com.reboot16.notes.Exception.ResourceNotFoundException;
import com.reboot16.notes.model.ErrorCode;
import com.reboot16.notes.model.entity.Tags;
import com.reboot16.notes.repositories.TagsRepository;
import com.reboot16.notes.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsServiceImplementation implements TagsService {

    @Autowired
    TagsRepository tagsRepository;

    @Override
    public Tags getTagsById(String tagsId) {
        if(!tagsRepository.existsByTagsId(tagsId)) {
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }
        return tagsRepository.findByTagsId(tagsId);
    }

    @Override
    public Tags getTagsByTagName(String tagName) {
        if(!tagsRepository.existsByTag(tagName)) {
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }
        return tagsRepository.findByTag(tagName);
    }

    @Override
    public List<Tags> getAllTagsByUserId(String userId) {
        return tagsRepository.findAllByUserId(userId);
    }

    @Override
    public List<Tags> getAllTagsContainName(String name) {
        List<Tags> tagsRes;
        tagsRes = tagsRepository.findByTagContaining(name);

        if(tagsRes == null) {
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }
        return tagsRes;
    }

    @Override
    public Tags createTags(Tags tags) {
        return tagsRepository.save(tags);
    }

    @Override
    public Tags updateTags(String tagsId, Tags tagsRequest) {
        Tags tags = tagsRepository.findByTagsId(tagsId);
        if(tags == null) {
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }

        tags.setTag(tagsRequest.getTag());
        return null;
    }

    @Override
    public Boolean deleteTags(String tagsId) {
        Tags tags = tagsRepository.findByTagsId(tagsId);
        if(tags == null) {
            throw new ResourceNotFoundException(
                    ErrorCode.NOT_FOUND.getCode(),
                    ErrorCode.NOT_FOUND.getMessage()
            );
        }
        return tagsRepository.deleteByTagsId(tagsId);
    }
}
