package com.autoindustry.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.autoindustry.backend.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

  @Query(value = "SELECT * FROM PRODUCTS WHERE NAME = ?1", nativeQuery = true)
  Optional<Products> findByName(String name);
	
}
