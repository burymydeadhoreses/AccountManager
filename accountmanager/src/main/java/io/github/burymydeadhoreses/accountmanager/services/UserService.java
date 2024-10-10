package io.github.burymydeadhoreses.accountmanager.services;

import io.github.burymydeadhoreses.accountmanager.exceptions.UserExistsException;
import io.github.burymydeadhoreses.accountmanager.exceptions.UserNotFoundException;
import io.github.burymydeadhoreses.accountmanager.models.User;
import io.github.burymydeadhoreses.accountmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void add(User user) {
        var storedUser = find(user.getUsername());

        if(storedUser != null)
            throw new UserExistsException(user.getUsername());

        repository.getUsers().add(user);
    }

    public void delete(User user) {
        var storedUser = find(user.getUsername());

        if(storedUser == null)
            throw new UserNotFoundException(user.getUsername());

        repository.getUsers().remove(storedUser);
    }

    public User get(String username) {
        var user = find(username);

        if(user == null)
            throw new UserNotFoundException(username);

        return user;
    }

    public List<User> list() {
        return repository.getUsers();
    }

    public void update(User user) {
        var storedUser = find(user.getUsername());

        if(storedUser == null)
            throw new UserNotFoundException(user.getUsername());

        storedUser.setEmail(user.getEmail());
    }

    private User find(String username) {
        return repository.getUsers()
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst().orElse(null);
    }
}
