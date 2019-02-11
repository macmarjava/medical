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

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    UserServiceImpl userService;
    static Logger log = Logger.getLogger(UserController.class.getName());

    //    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @GetMapping(path = {"/{id}"})
    public User getUser(@PathVariable("id") int id) {
        log.info("Esto es un mensaje de debug" + id);
        return userService.getUser(id);
    }

    @GetMapping(path = {"/"})
    public List<User> getUsers() {
        log.info("Esto es un mensaje de getUsers");
        return userService.getUsers();
    }

    @PostMapping("/create/{name}")
    public ResponseEntity<User> createUser(@Valid @RequestBody String name) {
        log.info("CREATE");
        return new ResponseEntity<User>(userService.createUser(name), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        log.info("DELETE");
        userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") int id, @Valid @RequestBody String name) {
        log.info("Update");
        User user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity(null, HttpStatus.OK);
        }

        userService.setUser(id, name);
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

}