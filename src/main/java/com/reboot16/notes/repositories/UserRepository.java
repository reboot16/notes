package com.reboot16.notes.repositories;

import com.reboot16.notes.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsByUserId(String userId);
}
