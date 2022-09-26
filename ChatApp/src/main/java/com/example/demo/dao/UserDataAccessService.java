package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, boolean isAdmin, User user) {
        return 0;
    }

    @Override
    public List<User> selectAllUsers() {
        final String sql = "SELECT id, isadmin, name FROM users";
        return jdbcTemplate.query(sql, ((rs, rowNum) -> {
            UUID id = UUID.fromString(rs.getString("id"));
            Boolean isAdmin = rs.getBoolean("isAdmin");
            String name = rs.getString("name");
            return new User(id, isAdmin, name);
        }));
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteUserById(UUID id) {
        return 0;
    }

    @Override
    public int updateUserByID(UUID id, User user) {
        return 0;
    }
}
