package com.example.demo.service;

import java.util.List;


import com.example.demo.Repository.IInstructorRepository;
import com.example.demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.InstructorDAO;
import com.example.demo.entities.Instructor;


@Service
@Transactional
public class InstructorService {

    @Autowired
    private InstructorDAO InstructorDAO;

    @Autowired
    private IInstructorRepository instructorRepository;

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
        return instructorRepository.findAll();
    }
    public Instructor findUserByStatusAndNameNamedParams(
            @Param("username") String username){return instructorRepository.findUserByStatusAndNameNamedParams(username);}

//    @org.springframework.data.jpa.repository.Query("SELECT u FROM Instructor u WHERE u.name like %:username%")
    public List<Instructor> findInstructorsByNameContaining(@Param("name") String name) {
        return instructorRepository.findInstructorsByNameContaining(name);
    }

    public List<Instructor> getAllByNameContaining(String name){return InstructorDAO.getAllByNameContaining(name);}


}
