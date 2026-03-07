package com.raj.invoice_inventory_system.controller;

import com.raj.invoice_inventory_system.model.Product;
import com.raj.invoice_inventory_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
    // Update an existing product (e.g., change price or quantity)
@PutMapping("/{id}")
public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    
    product.setName(productDetails.getName());
    product.setPrice(productDetails.getPrice());
    product.setQuantity(productDetails.getQuantity());
    
    return productRepository.save(product);
}

// Delete a product from inventory
@DeleteMapping("/{id}")
public String deleteProduct(@PathVariable Long id) {
    productRepository.deleteById(id);
    return "Product with ID " + id + " has been deleted.";
}
// Process a Sale: http://localhost:8081/api/products/sell/{id}/{quantity}
@PostMapping("/sell/{id}/{quantity}")
public String sellProduct(@PathVariable Long id, @PathVariable int quantity) {
    Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));

    if (product.getQuantity() < quantity) {
        return "Error: Not enough stock! Current stock: " + product.getQuantity();
    }

    // Update stock
    product.setQuantity(product.getQuantity() - quantity);
    productRepository.save(product);

    double totalPrice = product.getPrice() * quantity;
    
    return "Sale Successful! \nProduct: " + product.getName() + 
           "\nQuantity Sold: " + quantity + 
           "\nTotal Price: " + totalPrice + 
           "\nRemaining Stock: " + product.getQuantity();
}
}