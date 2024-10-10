package io.github.burymydeadhoreses.accountmanager.services;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

@Service
public class DataProcessingService {
    private final Dictionary<String, Date> registrationDate = new Hashtable<>();

    public DataProcessingService() {
    }

    public void add(String username) {
        registrationDate.put(username, new Date());
    }

    public long count() {
        return registrationDate.size();
    }
}
