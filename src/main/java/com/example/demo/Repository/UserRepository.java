package com.example.demo.Repository;

import com.example.demo.entities.Topic;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
