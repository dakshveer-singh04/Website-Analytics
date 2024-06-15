package org.websiteanalytics.ecomsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.websiteanalytics.ecomsite.dtos.UserRegisterationDTO;
import org.websiteanalytics.ecomsite.models.User;
import org.websiteanalytics.ecomsite.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/ec_website/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("PONG");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/registerUser")
    public ResponseEntity<User> createUser(@RequestBody UserRegisterationDTO userRegisterationDTO) {
        User createdUser = userService.createUser(userRegisterationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
