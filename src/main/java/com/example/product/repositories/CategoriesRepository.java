package com.example.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.models.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
