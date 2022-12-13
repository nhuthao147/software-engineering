package com.example.demo.Repository;

import com.example.demo.entities.Student;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT u FROM Student u WHERE u.user.username = :username")
    Student findUserByStatusAndNameNamedParams(
            @Param("username") String username);
}
