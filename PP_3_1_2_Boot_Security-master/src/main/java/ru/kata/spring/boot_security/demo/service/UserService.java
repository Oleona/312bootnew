package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService  {
    void add(User user);

    List<User> listUsers();

    void delete(Long userId);

    void update(User user, Long id);

    public User getUserById(Long userid);



}
