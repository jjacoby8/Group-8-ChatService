package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, boolean isAdmin, User user) {
        DB.add(new User(id, isAdmin, user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> foundUser = selectUserById(id);
        if (foundUser.isEmpty()) {
            return 0;
        }
        DB.remove(foundUser.get());
        return 1;
    }

    @Override
    public int updateUserByID(UUID id, User updatedUser) {
        return selectUserById(id)
                .map(user -> {
                    // If we find the user in the database, set the contents to the user received from the client
                    int indexOfUserToUpdate = DB.indexOf(user);
                    if (indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(id, updatedUser.isAdmin(), updatedUser.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
