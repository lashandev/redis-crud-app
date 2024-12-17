package com.lashan.mycrud.repository;

import com.lashan.mycrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    // You can add custom query methods if needed
    List<Employee> findByDepartmentDid(String did);
}
