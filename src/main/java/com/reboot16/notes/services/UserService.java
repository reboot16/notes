package com.reboot16.notes.services;

import com.reboot16.notes.model.entity.User;

public interface UserService {
    User getUserByUserId(String userId);
}
