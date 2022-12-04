package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.InstructorDAO;
import com.example.demo.entities.Instructor;


@Service
@Transactional
public class InstructorService {

    @Autowired
    private InstructorDAO InstructorDAO;

    public Instructor getInstructor(Long empId) {
        return InstructorDAO.getInstructor(empId);
    }

    public Instructor addInstructor (Instructor Instructor) {
        return InstructorDAO.addInstructor(Instructor);
    }

    public Instructor updateInstructor(Instructor Instructor) {
        return InstructorDAO.updateInstructor(Instructor);
    }

    public void deleteInstructor (Long empId) {
        InstructorDAO.deleteInstructor(empId);
    }

    public List<Instructor> getAllInstructors(){
        return InstructorDAO.getAllInstructor();
    }
}
