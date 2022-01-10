package com.yuce.envanter.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "customer_table")
@Data
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private int id;
    @Size(min = 3, max = 50)
    private String firstName;
    @Size(min = 3, max = 50)
    private String lastName;
    @Size(min = 3, max = 50)
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private LocalDate registrationDate;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private boolean blocked;

}
