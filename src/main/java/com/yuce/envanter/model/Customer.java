package com.yuce.envanter.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer_table")
@Data
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
