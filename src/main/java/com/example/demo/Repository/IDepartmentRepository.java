package com.example.demo.Repository;

import com.example.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Long> {
        @Query("SELECT u FROM Department u WHERE u.head_id = :username")
        Department findUserByStatusAndNameNamedParams(
                @Param("username") String username);


}
