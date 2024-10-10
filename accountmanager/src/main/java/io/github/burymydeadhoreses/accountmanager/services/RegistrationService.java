package io.github.burymydeadhoreses.accountmanager.services;

import io.github.burymydeadhoreses.accountmanager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserService userService;
    private final DataProcessingService dataProcessingService;

    @Autowired
    public RegistrationService(UserService userService,
                               DataProcessingService dataProcessingService) {

        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
    }

    public long register(User user) {
        userService.add(user);
        dataProcessingService.add(user.getUsername());

        return dataProcessingService.count();
    }
}
