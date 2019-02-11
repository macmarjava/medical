package com.example.demo.controller;

import com.example.demo.bd.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping({"/institution"})
public class InstitutionController {

    @Autowired
    UserServiceImpl userService;
    static Logger log = Logger.getLogger(UserController.class.getName());

    @GetMapping(path = {"/{id}"})
    public User getInstitution(@PathVariable("id") int id) {
        log.info("getInstitution" + id);
        return userService.getUser(id);
    }

}