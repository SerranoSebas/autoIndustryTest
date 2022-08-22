package com.autoindustry.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.autoindustry.backend.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	
  @Query(value = "SELECT * FROM INVENTORY i WHERE ID = ?1", nativeQuery = true)
  Optional<Inventory> findProductById(Integer id);
  
  @Query(value = "select i.* from Inventory i, Products p where i.id_product = p.id and p.name like ?1%", nativeQuery = true)
  Iterable<Inventory> findAllByProduct(String text);



}
