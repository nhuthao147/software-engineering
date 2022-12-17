package com.example.demo.Repository;

import com.example.demo.entities.JoinRequest;
import com.example.demo.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository  extends JpaRepository<Topic, Long> {
}