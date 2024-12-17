package com.lashan.mycrud.service.impl;


import com.lashan.mycrud.dto.DepartmentDTO;
import com.lashan.mycrud.entity.Department;
import com.lashan.mycrud.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl /*implements DepartmentService*/ {

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    // Save a department
    public DepartmentDTO saveDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);

    }

    // Get a department by ID
    public DepartmentDTO getDepartmentById(String did) {
        Optional<Department> byId = departmentRepository.findById(did);
        if(byId.isPresent())
            return modelMapper.map(byId.get(), DepartmentDTO.class);
        else
            throw new RuntimeException("Department not found with did: " + did);
    }

    // Get all departments
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentDTO> list = departmentRepository
                .findAll()
                .stream()
                .map((element) -> modelMapper.map(element, DepartmentDTO.class))
                .collect(Collectors.toList());
        return list;
    }

    // Update a department
    public DepartmentDTO updateDepartment(String did, Department updatedDepartment) {
        Optional<Department> existingDepartmentOptional = departmentRepository.findById(did);
        if (existingDepartmentOptional.isPresent()) {
            Department existingDepartment = existingDepartmentOptional.get();
            existingDepartment.setName(updatedDepartment.getName());
            return modelMapper.map(departmentRepository.save(existingDepartment), DepartmentDTO.class);
        } else {
            throw new RuntimeException("Department not found with did: " + did);
        }
    }

    // Delete a department by ID
    public void deleteDepartmentById(String did) {
        departmentRepository.deleteById(did);
    }
}
