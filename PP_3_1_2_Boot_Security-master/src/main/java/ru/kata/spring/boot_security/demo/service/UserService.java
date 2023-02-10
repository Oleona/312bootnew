package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(User user);

    List<User> listUsers();

    void delete(Long userId);

    void update(User user, Long id);

    public User getUserById(Long userid);
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

 UserDetails userAlreadyExists(String username);

}
