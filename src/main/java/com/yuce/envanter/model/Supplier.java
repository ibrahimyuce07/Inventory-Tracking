package com.yuce.envanter.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "supplier_table")
@Data
public class Supplier {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    private int id;

    private String companyName;
    @OneToOne
    @JoinColumn(name = "addres_id")
    private Address addres;
    private String webSite;
    private String contactPerson;
    private String contactPhone;
    private String contactEmail;
    private LocalDate contractStart;
    private boolean active;
}
