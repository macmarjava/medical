package com.example.demo.repository;

import com.example.demo.bd.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Usuario implements UsuarioDto {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(int id) {
        return userRepository.findOne((long) id);
    }

    @Override
    public User createUser(String name) {
        return userRepository.save(new User(name));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete((long) id);
    }

    @Override
    public void setUser(int id, String name) {
        User user = userRepository.findOne((long) id);
        user.setName(name);
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
