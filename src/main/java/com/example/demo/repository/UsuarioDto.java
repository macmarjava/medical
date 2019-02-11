package com.example.demo.repository;

import com.example.demo.bd.User;

import java.util.List;

public interface UsuarioDto {
    User getUser(int id);
    User createUser(String name);
    void deleteUser(int  id);
    void setUser(int id,String name);
    List<User> getUsers();
}
