package com.agent47.springbootstudy.services;

import com.agent47.springbootstudy.entity.Department;
import com.agent47.springbootstudy.error.DepartmentNotFoundException;
import com.agent47.springbootstudy.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("No Deparment Found under that Id");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department dbupd=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&(!"".equalsIgnoreCase(department.getDepartmentName()))){
            dbupd.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&(!"".equalsIgnoreCase(department.getDepartmentAddress()))){
            dbupd.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&(!"".equalsIgnoreCase(department.getDepartmentCode()))){
            dbupd.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(dbupd);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

}
