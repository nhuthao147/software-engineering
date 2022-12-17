package com.example.demo.dao;

import java.util.Collection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;



@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Student getStudent(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Student emp = session.get(Student.class, empId);
        return emp;
    }
    public Student getStudent(String username){
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
//        Student listStudent =(Student) session.createQuery("FROM Student WHERE User.username = "+username).list().get(0);
        String sql = "FROM Student WHERE User.username = :username";
        Query query = session.createQuery(sql);
        query.setParameter("username", username);

        Student listStudent2 = (Student) query.getResultList().get(0);
        return listStudent2;
    }

    public Student addStudent(Student empForm) {
        Session session = sessionFactory.getCurrentSession();
        session.save(empForm);
        return empForm;
    }

    public Student updateStudent(Student empForm) {
        Session session = sessionFactory.getCurrentSession();
        Student emp = session.get(Student.class, empForm.getId());
        emp.setStudentId(empForm.getStudentId());
        emp.setName(empForm.getName());
        emp.setBirthday(empForm.getBirthday());
        emp.setEndDay(empForm.getEndDay());
        emp.setStartDay(empForm.getStartDay());
        emp.setTopic(empForm.getTopic());
        session.update(emp);
        return emp;
    }

    public void deleteStudent(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Student emp = session.get(Student.class, empId);
        session.delete(emp);
    }

    public List<Student> getAllStudent(){
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Student> listStudent = session.createQuery(" FROM " + Student.class.getName()).list();
        return listStudent;
    }
}
