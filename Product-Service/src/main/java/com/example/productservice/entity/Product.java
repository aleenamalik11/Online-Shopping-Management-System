package com.example.productservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_code")
    private String code;

    @Column(name = "product_name")
    @NotBlank(message = "Please Enter the Product Name")
    private String name;

    @Column(name = "brand_id")
    @NotBlank(message = "Please Enter the Brand Name")
    private String brand;

    @Column(name = "description")
    @JsonIgnore
    @NotBlank(message = "Please Enter the Product Description")
    private String description;

    @Column(name = "unit_price")
    @Min(value = 1, message = "Unit Price atleast one (1)")
    private double unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "category_id")
    @JsonIgnore
    private int categoryId;

    @Column(name = "supplier_id")
    @JsonIgnore
    private int supplierId;

}

