package com.reboot16.notes.repositories;

import com.reboot16.notes.model.entity.Tags;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagsRepository extends MongoRepository<Tags, String> {
    Tags findByTagsId(String tagsid);
    Tags findByTag(String tag);
    List<Tags> findAllByUserId(String userId);
    List<Tags> findByTagContaining(String tag);
    Boolean existsByTagsId(String tagsId);
    Boolean existsByTag(String tag);
    Boolean deleteByTagsId(String tagsId);
}
