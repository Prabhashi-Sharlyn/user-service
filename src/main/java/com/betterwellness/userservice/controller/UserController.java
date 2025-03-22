package com.betterwellness.userservice.controller;

import com.betterwellness.userservice.model.User;
import com.betterwellness.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        if (userService.userExists(user.getUuid())) {
            return "User already exists!";
        }
        userService.saveUser(user);
        return "User saved successfully!";
    }

    @GetMapping("/counsellors")
    public ResponseEntity<List<User>> getCounsellors() {
        List<User> counsellors = userService.getAllCounsellors();
        return ResponseEntity.ok(counsellors);
    }
}
