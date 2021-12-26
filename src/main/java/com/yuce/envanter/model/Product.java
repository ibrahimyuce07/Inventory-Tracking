package com.yuce.envanter.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_table")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private int id;
    @NotNull(message = "Ürün adı boş olamaz")
    @Size(min = 3, max = 50, message = "Ürün adı 3-50 karakter arasında olmalıdır")
    private String name;
    @NotNull(message = "Ürün tipi boş olamaz")
    private String type;
    @NotNull(message = "Ürün fiyatı boş olamaz")
    private BigDecimal price;
    @NotNull(message = "Ürün adedi boş olamaz")
    private int quantity;
    @Size(min = 3, max = 250, message = "Ürün açıklaması 3-50 karakter arasında olmalıdır")
    private String description;
    private boolean status;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
}
