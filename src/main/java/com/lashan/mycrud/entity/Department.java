/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lashan.mycrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author lashan_chandika
 */
@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "did")
    @NotNull(message = "Department ID can't be empty")
    @NotBlank(message = "Department ID can't be empty")
    private String did;

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department")
    @NotNull(message = "Department Name can't be empty")
    @NotBlank(message = "Department Name can't be empty")
    private List<Employee> employeeCollection;


    
}
