package com.autoindustry.backend.rest;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autoindustry.backend.entities.Inventory;
import com.autoindustry.backend.repositories.InventoryRepository;
import com.autoindustry.backend.services.InventoryService;

@RestController
@RequestMapping("/Inventory")
@CrossOrigin("*")
public class InventoryREST {

	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	/*@RequestMapping(value="/all", method = RequestMethod.GET)
	private ResponseEntity<List<Inventory>> getAllInventory(){
		return ResponseEntity.ok(inventoryService.findAll());
	}*/
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public Iterable<Inventory> views(){
		return inventoryService.findAll();
	}
	
	
	@RequestMapping(value="/allByProduct/{text}", method = RequestMethod.GET)
	public Iterable<Inventory> views(@PathVariable String text){
		System.out.println("Text: " + text);
		return inventoryRepository.findAllByProduct(text);
	}
	
	@RequestMapping(value="/find/{id}", method = RequestMethod.GET)
	public Optional<Inventory> view(@PathVariable Integer id){
		if(inventoryRepository.findProductById(id) != null) {
			return inventoryRepository.findProductById(id);
		}
		return null;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Inventory add(@RequestBody Inventory inventory) throws Exception {
		return this.inventoryService.save(inventory);
	}
	
	@RequestMapping(value="/save/{id}", method = RequestMethod.PUT)
	public Inventory modify(@RequestBody Inventory inventory, @PathVariable Integer id) throws Exception {
		if(inventoryRepository.findProductById(id) != null) {
			Optional<Inventory> inventoryItem = inventoryRepository.findProductById(id);
			System.out.println("inventoryItem: " + inventoryItem.get());
			inventory.setId(inventory.getId());
			inventory.setProduct(inventory.getProduct());
			inventory.setQuantity(inventory.getQuantity());
			inventory.setUpdated_date(inventory.getUpdated_date());
			inventory.setCreated_date(inventory.getCreated_date());
			inventory.setUser(inventory.getUser());
			return inventoryRepository.save(inventory);
		}
		return null;
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
		inventoryService.deleteById(id);
		System.out.println("Id : " +id+ " was deleted");
	}
	
	
}
