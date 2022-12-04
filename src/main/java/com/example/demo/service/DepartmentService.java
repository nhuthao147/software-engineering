package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DepartmentDAO;
import com.example.demo.entities.Department;


@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentDAO DepartmentDAO;

    public Department getDepartment(Long empId) {
        return DepartmentDAO.getDepartment(empId);
    }

    public Department addDepartment (Department Department) {
        return DepartmentDAO.addDepartment(Department);
    }

    public Department updateDepartment(Department Department) {
        return DepartmentDAO.updateYmployee(Department);
    }

    public void deleteDepartment (Long empId) {
        DepartmentDAO.deleteDepartment(empId);
    }

    public List<Department> getAllDepartments(){
        return DepartmentDAO.getAllDepartment();
    }
}
