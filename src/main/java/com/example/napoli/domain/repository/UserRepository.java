package com.example.napoli.domain.repository;

import com.example.napoli.domain.entity.Carpool;
import com.example.napoli.domain.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
