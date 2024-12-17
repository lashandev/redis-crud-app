package com.lashan.mycrud.repository;

import com.lashan.mycrud.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    // You can add custom query methods if needed
}
