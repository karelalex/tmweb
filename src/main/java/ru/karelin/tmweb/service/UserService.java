package ru.karelin.tmweb.service;

import ru.karelin.tmweb.entity.User;
import ru.karelin.tmweb.repository.UserRepository;
import ru.karelin.tmweb.util.MD5Generator;

public class UserService {
    private static UserService ourInstance = new UserService();
    private UserRepository userRepository = UserRepository.getInstance();

    public static UserService getInstance() {
        return ourInstance;
    }

    private UserService() {
    }
    public User findByLoginAndPassword(String login, String password){
        User user = userRepository.findByLogin(login);
        if (user!=null && user.getPassHash().equals(MD5Generator.generate(password))){
            return user;
        }
        return null;
    }
    public User find(String id){
        return userRepository.find(id);
    }

    public boolean checkLogin(String login) {
        return userRepository.findByLogin(login)!=null;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
