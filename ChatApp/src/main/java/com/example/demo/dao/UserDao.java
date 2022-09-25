package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    // Create user with ID
    int insertUser(UUID id, boolean isAdmin, User user);

    // Create user and assign them an ID
    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user.isAdmin(), user);
    }

    List<User> selectAllUsers();

    Optional<User> selectUserById(UUID id);

    int deleteUserById(UUID id);

    int updateUserByID(UUID id, User user);
}
