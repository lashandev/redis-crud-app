package com.lashan.mycrud.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeDTO {
    @NotNull(message = "Employee ID can't be empty")
    private String empno;
    @NotNull(message = "Employee Name can't be empty")
    private String name;
    private Integer age;
    private Double salary;
    private DepartmentDTO department;
}
