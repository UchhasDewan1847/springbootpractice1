package com.agent47.springbootstudy.services;

import com.agent47.springbootstudy.entity.Department;
import com.agent47.springbootstudy.error.DepartmentNotFoundException;
import com.agent47.springbootstudy.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartments();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
