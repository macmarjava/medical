package com.example.demo.service;

import com.example.demo.bd.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Usuario usuario;

    @Override
    public User getUser(int id) {
        return usuario.getUser(id);
    }

    @Override
    public List<User> getUsers()
    {
        return usuario.getUsers();
    }

    @Override
    public void setUser(int id, String name) {
        List<User> users = userRepository.findAll();
        if(!existUser(users, name)){
            usuario.setUser(id, name);
        }
    }


    private boolean existUser(List<User> users, String name) {
        for (User user : users) {
            if (name.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User createUser(String name) {
        //logica
        return usuario.createUser(name);
    }

    @Override
    public void deleteUser(int  id) {
         usuario.deleteUser(id);
    }
}
