package com.example.vacation.repository;

import com.example.vacation.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll(Sort id);

    // Custom search method for searching by name or category (case-insensitive)
    List<Product> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name, String category);
}
