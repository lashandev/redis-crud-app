package com.lashan.mycrud.service;

import com.lashan.mycrud.dto.DepartmentDTO;
import com.lashan.mycrud.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment(Department department);

    DepartmentDTO getDepartmentById(String did);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO updateDepartment(String did, Department updatedDepartment);

    void deleteDepartmentById(String did);
}
