package com.example.demo.dao;

import com.example.demo.entities.JoinRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRequestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public JoinRequest getJoinRequest(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        JoinRequest emp = session.get(JoinRequest.class, empId);
        return emp;
    }

    public JoinRequest addJoinRequest(JoinRequest empForm) {
        Session session = sessionFactory.getCurrentSession();
        session.save(empForm);
        return empForm;
    }

    public JoinRequest updateJoinRequest(JoinRequest empForm) {
        Session session = sessionFactory.getCurrentSession();
        JoinRequest emp = session.get(JoinRequest.class, empForm.getId());
        emp.setId(empForm.getId());
        emp.setStatus(empForm.getStatus());
        emp.setStudent(empForm.getStudent());
        emp.setTopic(empForm.getTopic());
        session.update(emp);
        return emp;
    }

    public void deleteJoinRequest(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        JoinRequest emp = session.get(JoinRequest.class, empId);
        session.delete(emp);
    }

    public List<JoinRequest> getAllJoinRequest(){
        Session session = sessionFactory.getCurrentSession();
        List<JoinRequest> listJoinRequest = session.createQuery(" FROM " + JoinRequest.class.getName()).list();
        return listJoinRequest;


    }
}
