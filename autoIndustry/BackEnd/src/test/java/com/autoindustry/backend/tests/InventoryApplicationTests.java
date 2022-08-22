package com.autoindustry.backend.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.autoindustry.backend.entities.Products;
import com.auto_industry.services.InventoryService;
import com.autoindustry.backend.entities.Inventory;
import com.autoindustry.backend.repositories.InventoryRepository;


@SpringBootTest
class InventoryApplicationTests {

	
	@Mock
	private InventoryRepository inventoryRepository;
	
	@InjectMocks
	private InventoryService inventoryService;
	
	private Inventory inventory;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		
		inventory = new Inventory();
		inventory.setProduct(new Products());
		inventory.setQuantity(10);
	}
	
	@Test
	void findAll() {
		//when(inventoryRepository.findAll().thenReturn());
	}
	
}
