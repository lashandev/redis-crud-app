package com.lashan.mycrud.service.impl;
import com.lashan.mycrud.dto.DepartmentDTO;
import com.lashan.mycrud.entity.Department;
import com.lashan.mycrud.repository.DepartmentRepository;
import com.lashan.mycrud.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceEnableCache implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @CachePut(value = "departments", key = "#department.did")
    public DepartmentDTO saveDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    @Cacheable(value = "departments", key = "#did")
    public DepartmentDTO getDepartmentById(String did) {
        Optional<Department> byId = departmentRepository.findById(did);
        if(byId.isPresent())
            return modelMapper.map(byId.get(), DepartmentDTO.class);
        else
            throw new RuntimeException("Department not found with did: " + did);
    }

    @Cacheable(value = "departments")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @CachePut(value = "departments", key = "#did")
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

    @CacheEvict(value = "departments", key = "#did")
    public void deleteDepartmentById(String did) {
        departmentRepository.deleteById(did);
    }
}