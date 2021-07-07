package com.example.indepth.controller;

import com.example.indepth.entity.Department;
import com.example.indepth.error.DepartmentNotFoundException;
import com.example.indepth.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

//Dependency injection
//Autowired means it will wire to the reference
//allows you to create obj without instantiating them
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
//    Convert body into a Department obj named department
//    @Valid maps to the validation params in Department
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of Department Controller");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> allDepartments(){
        LOGGER.info("Inside allDepartments of Department Controller");
        return departmentService.allDepartments();
    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside getDepartmentById of Department Controller");
        return departmentService.getDepartmentById(departmentId);

    }
    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Inside deleteDepartment of Department Controller");
         departmentService.deleteDepartment(departmentId);
        return "Deleted user with ID " + departmentId;
    }

    @PutMapping("/departments/{departmentId}")
    public Department updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of Department Controller");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{department}")
    public Department getDepartment(@PathVariable("department")String department){
        LOGGER.info("Inside getDepartment of Department Controller");
        return departmentService.getDepartment(department);
    }


}
