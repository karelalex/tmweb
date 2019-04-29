package ru.karelin.tmweb.repository;

import org.jetbrains.annotations.NotNull;
import ru.karelin.tmweb.entity.Project;
import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.enumeration.Status;

import java.util.*;

public class UserRepository {
    private static final UserRepository ourInstance = new UserRepository();
    private final Map<String, User> userMap = new LinkedHashMap<>();

    public static UserRepository getInstance() {
        return ourInstance;
    }

    private UserRepository() {

    }

    public User find(String userId) {
        for (User u : userMap.values()
        ) {
            if (u.getId().equals(userId)) return u;
        }
        return null;
    }

    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    public void remove(@NotNull User user) {
        userMap.remove(user.getId());
    }

    public User findByLogin(String login) {
        for (User u : userMap.values()) {
            if(u.getLogin().equals(login)) return u;
        }
        return null;
    }
}
