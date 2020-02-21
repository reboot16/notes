package com.reboot16.notes.services;

import com.reboot16.notes.model.entity.Tags;

import java.util.List;

public interface TagsService {
    Tags getTagsById(String tagsId);
    Tags getTagsByTagName(String tagName);

    List<Tags> getAllTagsByUserId(String userId);
    List<Tags> getAllTagsContainName(String name);

    Tags createTags(Tags tags);
    Tags updateTags(String tagsId ,Tags tagsRequest);

    Boolean deleteTags(String tagsId);
}
