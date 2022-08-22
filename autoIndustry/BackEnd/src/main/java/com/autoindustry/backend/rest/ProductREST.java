package com.autoindustry.backend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autoindustry.backend.entities.Products;
import com.autoindustry.backend.repositories.ProductRepository;


@RestController
@RequestMapping("/Products")
@CrossOrigin("*")
public class ProductREST {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Products add(@RequestBody Products product) throws Exception {
		return this.productRepository.save(product);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
	@RequestMapping(value="/findByName/{name}", method = RequestMethod.GET)
	public Optional<Products> view(@PathVariable String name){
		System.out.println(productRepository.findByName(name));
		if(productRepository.findByName(name) != null) {
			return productRepository.findByName(name);
		}
		throw new IllegalArgumentException("Name not found");
	}
	
	
	
}
