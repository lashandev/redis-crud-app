package com.lashan.mycrud.service.impl;

import com.lashan.mycrud.dto.EmployeeDTO;
import com.lashan.mycrud.entity.Employee;
import com.lashan.mycrud.repository.EmployeeRepository;
import com.lashan.mycrud.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    // Save an employee
    @CachePut(value = "employees", key = "#employee.empno")
    public EmployeeDTO saveEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    // Get an employee by ID
    @Cacheable(value = "employees", key = "#empno")
    public EmployeeDTO getEmployeeById(String empno) {
        Optional<Employee> byId = employeeRepository.findById(empno);
        if (byId.isPresent())
            return modelMapper.map(byId.get(), EmployeeDTO.class);
        return null;
    }

    // Get all employees
    @Cacheable(value = "employees")
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, EmployeeDTO.class))
                .collect(Collectors.toList());
        return employeeDTOList;
    }

    // Get employees by department ID
    @CachePut(value = "employees", key = "#empno")
    public List<EmployeeDTO> getEmployeesByDepartmentId(String did) {
        List<EmployeeDTO> employeeDTOList = employeeRepository
                .findByDepartmentDid(did)
                .stream()
                .map(user -> modelMapper.map(user, EmployeeDTO.class))
                .collect(Collectors.toList());
        return employeeDTOList;
    }

    // Update an employee
    @Cacheable(value = "employees", key = "#empno")
    public EmployeeDTO updateEmployee(String empno, Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(empno);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            return modelMapper.map(employeeRepository.save(existingEmployee), EmployeeDTO.class);
        } else {
            throw new RuntimeException("Employee not found with empno: " + empno);
        }
    }

    // Delete an employee by ID
    @CacheEvict(value = "departments", key = "#did")
    public void deleteEmployeeById(String empno) {
        employeeRepository.deleteById(empno);
    }
}


