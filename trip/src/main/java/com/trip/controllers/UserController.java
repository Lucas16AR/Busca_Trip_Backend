package com.trip.controllers;

import com.trip.models.UserModel;
import com.trip.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserModel user) {
        UserModel savedUser = userService.addUser(user);
        if (savedUser != null) {
            return ResponseEntity.status(201).body("User added successfully with ID: " + savedUser.getId());
        } else {
            return ResponseEntity.status(400).body("Failed to add user.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody UserModel user) {
        UserModel existingUser = userService.getUser(id);

        if (existingUser != null) {
            user.setId(id);
            userService.updateUser(id, user);
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        UserModel existingUser = userService.getUser(id);

        if (existingUser != null) {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable("id") Long id) {
        UserModel user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


