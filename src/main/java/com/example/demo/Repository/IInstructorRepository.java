package com.example.demo.Repository;

import com.example.demo.entities.Instructor;
import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("SELECT u FROM Instructor u WHERE u.user.username = :username")
    Instructor findUserByStatusAndNameNamedParams(
            @Param("username") String username);
}
