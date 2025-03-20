package com.betterwellness.userservice.repository;

import com.betterwellness.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByRole(String role);
}
