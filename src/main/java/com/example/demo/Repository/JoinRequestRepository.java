package com.example.demo.Repository;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.JoinRequest;
import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinRequestRepository extends JpaRepository<JoinRequest, Long> {
    @Query("SELECT u FROM JoinRequest u WHERE u.student.id = :username")
    JoinRequest findUserByStatusAndNameNamedParams(
            @Param("username") Long username);

    JoinRequest findByTopic_Id(Long id);
}
