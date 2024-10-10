package io.github.burymydeadhoreses.accountmanager.services;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notify(String message) {
        System.out.println(message);
    }
}
