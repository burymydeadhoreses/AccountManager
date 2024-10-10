package io.github.burymydeadhoreses.accountmanager.controllers;

import io.github.burymydeadhoreses.accountmanager.models.User;
import io.github.burymydeadhoreses.accountmanager.services.NotificationService;
import io.github.burymydeadhoreses.accountmanager.services.RegistrationService;
import io.github.burymydeadhoreses.accountmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final RegistrationService registrationService;
    private final UserService userService;
    private final NotificationService notificationService;

    @Autowired
    public UserController(RegistrationService registrationService,
                          UserService userService,
                          NotificationService notificationService) {

        this.registrationService = registrationService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<User> list() {
        notificationService.notify("user list requested");

        return userService.list();
    }

    @GetMapping("/{username}")
    public User get(@PathVariable String username) {
        notificationService.notify("user get requested");

        return userService.get(username);
    }

    @PostMapping()
    public long add(@RequestBody User user) {
        notificationService.notify("user registration requested");

        return registrationService.register(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        notificationService.notify("user update requested");

        userService.update(user);
    }

    @DeleteMapping("/{username}")
    public void delete(@RequestBody User user) {
        notificationService.notify("user delete requested");

        userService.delete(user);
    }
}
