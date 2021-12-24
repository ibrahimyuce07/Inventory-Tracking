package com.yuce.envanter.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_table")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private int id;
    private String name;
    private String type;
    private BigDecimal price;
    private int quantity;
    private String description;
    private boolean status;
    private LocalDateTime createdDate;
    private int createdBy;
    private LocalDateTime modifiedDate;
    private int modifiedBy;
}
