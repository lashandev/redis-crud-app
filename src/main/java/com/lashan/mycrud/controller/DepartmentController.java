package com.lashan.mycrud.controller;

import com.lashan.mycrud.dto.DepartmentDTO;
import com.lashan.mycrud.entity.Department;
import com.lashan.mycrud.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Department Management System")
@Log4j2
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody Department department) {
        DepartmentDTO savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    @GetMapping("/{did}")
//    @Cacheable(value = "departments", key = "#did")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable String did) {
        DepartmentDTO department = departmentService.getDepartmentById(did);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Get all departments")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PutMapping("/{did}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable String did, @RequestBody Department updatedDepartment) {
        try {
            DepartmentDTO department = departmentService.updateDepartment(did, updatedDepartment);
            return ResponseEntity.ok(department);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{did}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable String did) {
        departmentService.deleteDepartmentById(did);
        return ResponseEntity.noContent().build();
    }
}
