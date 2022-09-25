package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

    private static List<User> fakeDB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, boolean isAdmin, User user) {
        fakeDB.add(new User(id, isAdmin, user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return fakeDB;
    }
}
