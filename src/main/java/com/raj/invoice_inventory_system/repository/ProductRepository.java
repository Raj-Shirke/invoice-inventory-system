package com.raj.invoice_inventory_system.repository;

import com.raj.invoice_inventory_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository gives you save(), findAll(), findById(), and delete() for free!
}