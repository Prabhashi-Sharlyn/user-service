package com.betterwellness.userservice.service;

import com.betterwellness.userservice.model.User;
import com.betterwellness.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean userExists(String uuid) {
        return userRepository.existsById(uuid); // Check if UUID exists
    }

    public void saveUser(User user) {
        if (!userExists(user.getUuid())) {
            userRepository.save(user);
        } else {
            throw new RuntimeException("User with UUID " + user.getUuid() + " already exists.");
        }
    }

    public List<User> getAllCounsellors() {
        return userRepository.findByRole("counsellor");
    }
}
