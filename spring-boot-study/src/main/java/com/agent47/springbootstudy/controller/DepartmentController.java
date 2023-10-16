package com.agent47.springbootstudy.controller;

import com.agent47.springbootstudy.entity.Department;
import com.agent47.springbootstudy.error.DepartmentNotFoundException;
import com.agent47.springbootstudy.services.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment method of the DepartmentController Class");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        LOGGER.info("Inside fetchDepartment method of the DepartmentController Class");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return  departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
