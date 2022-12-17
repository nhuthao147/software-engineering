package com.example.demo.service;

import java.util.Collection;
import java.util.List;


import com.example.demo.Repository.IStudentRepository;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entities.Student;


@Service
@Transactional
public class StudentService {

    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private StudentDAO StudentDAO;

    public Student getStudent(Long empId) {
        return StudentDAO.getStudent(empId);
    }

    public Student addStudent (Student Student) {
        return studentRepository.save(Student);
    }


    public Student updateStudent(Student Student) {
        return studentRepository.save(Student);
    }

    public void deleteStudent (Long empId) {
        StudentDAO.deleteStudent(empId);
    }

    public List<Student> getAllStudents(){
        return StudentDAO.getAllStudent();
    }


    public Student findStudentByUser_Username(String username){return studentRepository.findStudentsByUser_Username(username).get(0);}


    public Student getById(Long aLong) {
        return studentRepository.getById(aLong);
    }
}
