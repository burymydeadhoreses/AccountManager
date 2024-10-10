package io.github.burymydeadhoreses.accountmanager.exceptions;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String username) {
        super("User " + username + " already exists");
    }
}
