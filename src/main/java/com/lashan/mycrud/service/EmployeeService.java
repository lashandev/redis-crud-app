package com.lashan.mycrud.service;

import com.lashan.mycrud.dto.EmployeeDTO;
import com.lashan.mycrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(Employee employee);

    EmployeeDTO getEmployeeById(String empno);

    List<EmployeeDTO> getAllEmployees();

    List<EmployeeDTO> getEmployeesByDepartmentId(String did);

    EmployeeDTO updateEmployee(String empno, Employee updatedEmployee);

    void deleteEmployeeById(String empno);
}
