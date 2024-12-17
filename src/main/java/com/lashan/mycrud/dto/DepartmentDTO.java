package com.lashan.mycrud.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DepartmentDTO {
    @NotNull(message = "Department ID can't be empty")
    private String did;
    @NotNull(message = "Department Name can't be empty")
    private String name;
}
