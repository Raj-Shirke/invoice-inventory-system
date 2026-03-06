package com.raj.invoice_inventory_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data // This is from Lombok, it creates Getters and Setters automatically
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer quantity;
}