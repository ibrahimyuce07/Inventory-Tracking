package com.yuce.envanter.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address_table")
@Data
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private Long id;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private String country;

}
