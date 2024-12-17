/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lashan.mycrud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lashan_chandika
 */
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "empno")
    private String empno;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "salary")
    private BigDecimal salary;
    @JoinColumn(name = "did", referencedColumnName = "did")
    @ManyToOne
    private Department department;



    @Override
    public String toString() {
        return "com.lashan.mycrud.entity.Employee[ empno=" + empno + " ]";
    }
    
}
