package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entities.Student;


@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentDAO StudentDAO;

    public Student getStudent(Long empId) {
        return StudentDAO.getStudent(empId);
    }

    public Student addStudent (Student Student) {
        return StudentDAO.addStudent(Student);
    }

    public Student updateStudent(Student Student) {
        return StudentDAO.updateStudent(Student);
    }

    public void deleteStudent (Long empId) {
        StudentDAO.deleteStudent(empId);
    }

    public List<Student> getAllStudents(){
        return StudentDAO.getAllStudent();
    }
}