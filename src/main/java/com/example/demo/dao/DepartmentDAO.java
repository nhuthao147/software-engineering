package com.example.demo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Department;



@Repository
public class DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Department getDepartment(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Department emp = session.get(Department.class, empId);
        return emp;
    }

    public Department addDepartment(Department empForm) {
        Session session = sessionFactory.getCurrentSession();
        session.save(empForm);
        return empForm;
    }

    public Department updateYmployee(Department empForm) {
        Session session = sessionFactory.getCurrentSession();
        Department emp = session.get(Department.class, empForm.getId());
        emp.setDepartment_id(empForm.getDepartment_id());
        emp.setName(empForm.getName());
        emp.setId(empForm.getId());
        session.update(emp);
        return emp;
    }

    public void deleteDepartment(Long empId) {
        Session session = sessionFactory.getCurrentSession();
        Department emp = session.get(Department.class, empId);
        session.delete(emp);
    }

    public List<Department> getAllDepartment(){
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Department> listDepartment = session.createQuery(" FROM " + Department.class.getName()).list();
        return listDepartment;
    }
}
