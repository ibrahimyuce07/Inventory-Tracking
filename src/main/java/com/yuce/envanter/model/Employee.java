package com.yuce.envanter.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee_table")
@Data
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String title;
    private RoleEnum role;
    private BigDecimal salary;
    private LocalDate hiredDate;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
