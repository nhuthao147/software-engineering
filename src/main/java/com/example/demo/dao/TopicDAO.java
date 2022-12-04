package com.example.demo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Topic;



@Repository
public class TopicDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Topic getTopic(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Topic emp = session.get(Topic.class, empId);
        return emp;
    }

    public Topic addTopic(Topic empForm) {
        Session session = sessionFactory.getCurrentSession();
        session.save(empForm);
        return empForm;
    }

    public Topic updateTopic(Topic empForm) {
        Session session = sessionFactory.getCurrentSession();
        Topic emp = session.get(Topic.class, empForm.getId());
        emp.setEndDay(empForm.getEndDay());
        emp.setStartDay(empForm.getStartDay());
        emp.setTopicId(empForm.getTopicId());
        emp.setDepartment(empForm.getDepartment());
        emp.setDescription(empForm.getDescription());
        emp.setStatus(empForm.getStatus());
        emp.setHeadOfDepartment(empForm.getHeadOfDepartment());
        emp.setStudents(empForm.getStudents());
        session.update(emp);
        return emp;
    }

    public void deleteTopic(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Topic emp = session.get(Topic.class, empId);
        session.delete(emp);
    }

    public List<Topic> getAllTopic(){
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Topic> listTopic = session.createQuery(" FROM " + Topic.class.getName()).list();
        return listTopic;
    }
}
