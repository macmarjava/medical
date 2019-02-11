package com.example.demo.service;

import com.example.demo.bd.User;

import java.util.List;

public interface UserService {

    User getUser(int id);
    User createUser(String name);
    List<User> getUsers();
    void setUser(int id, String name);
    void deleteUser(int id);
}
