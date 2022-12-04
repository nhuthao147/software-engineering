package com.example.demo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Instructor;



@Repository
public class InstructorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Instructor getInstructor(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Instructor emp = session.get(Instructor.class, empId);
        return emp;
    }

    public Instructor addInstructor(Instructor empForm) {
        Session session = sessionFactory.getCurrentSession();
        session.save(empForm);
        return empForm;
    }

    public Instructor updateInstructor(Instructor empForm) {
        Session session = sessionFactory.getCurrentSession();
        Instructor emp = session.get(Instructor.class, empForm.getId());
        emp.setInstructorId(empForm.getInstructorId());
        emp.setName(empForm.getName());
        emp.setBirthday(empForm.getBirthday());
        emp.setEndDay(empForm.getEndDay());
        emp.setStartDay(empForm.getStartDay());
        session.update(emp);
        return emp;
    }

    public void deleteInstructor(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Instructor emp = session.get(Instructor.class, empId);
        session.delete(emp);
    }

    public List<Instructor> getAllInstructor(){
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Instructor> listInstructor = session.createQuery(" FROM " + Instructor.class.getName()).list();
        return listInstructor;
    }
}
