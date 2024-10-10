package io.github.burymydeadhoreses.accountmanager.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class User {
    private final String username;
    private final Date birthdate;

    @Setter
    private String email;

    public User(String username, Date birthdate, String email) {
        this.username = username;
        this.birthdate = birthdate;
        this.email = email;
    }
}
