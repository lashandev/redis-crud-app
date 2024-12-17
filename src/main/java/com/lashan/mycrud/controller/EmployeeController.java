package com.lashan.mycrud.controller;

import com.lashan.mycrud.dto.EmployeeDTO;
import com.lashan.mycrud.entity.Employee;
import com.lashan.mycrud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Management System")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @Operation(summary = "Create a new employee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody Employee employee) {
        EmployeeDTO savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{empno}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String empno) {
        EmployeeDTO employeeById = employeeService.getEmployeeById(empno);
        if (employeeById != null) {
            return ResponseEntity.ok(employeeById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Get all employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/department/{did}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartmentId(@PathVariable String did) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByDepartmentId(did);
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{empno}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String empno, @RequestBody Employee updatedEmployee) {
        try {
            EmployeeDTO employee = employeeService.updateEmployee(empno, updatedEmployee);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{empno}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable String empno) {
        employeeService.deleteEmployeeById(empno);
        return ResponseEntity.noContent().build();
    }
}
