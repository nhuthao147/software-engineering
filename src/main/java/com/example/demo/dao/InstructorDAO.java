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
        empForm.setInstructor_id("GV"+empForm.getId());
        return empForm;
    }

    public Instructor updateInstructor(Instructor empForm) {
        Session session = sessionFactory.getCurrentSession();
        Instructor emp = session.get(Instructor.class, empForm.getId());
        emp.setInstructor_id(empForm.getInstructor_id());
        emp.setName(empForm.getName());
        emp.setBirthday(empForm.getBirthday());
        emp.setEnd_day(empForm.getEnd_day());
        emp.setStart_day(empForm.getStart_day());
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
    public List<Instructor> getAllByNameContaining(String name) {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Instructor> listInstructor =
                session.createQuery(" FROM " + Instructor.class.getName() + " WHERE name LIKE " + "" + name.toString() + "").list();
        return listInstructor;
    }
}
