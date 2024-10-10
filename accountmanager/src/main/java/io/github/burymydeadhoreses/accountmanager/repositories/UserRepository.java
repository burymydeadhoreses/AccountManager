package io.github.burymydeadhoreses.accountmanager.repositories;

import io.github.burymydeadhoreses.accountmanager.models.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class UserRepository {
    private final List<User> users = new ArrayList<>();
}
