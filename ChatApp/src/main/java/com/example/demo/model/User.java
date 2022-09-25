package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    private final UUID id;
    private final boolean isAdmin;
    private final String name;


    public User(@JsonProperty("id") UUID id,
                @JsonProperty("isAdmin") boolean isAdmin,
                @JsonProperty("name") String name) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
