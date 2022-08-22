package com.autoindustry.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.autoindustry.backend.entities.Products;
import com.autoindustry.backend.repositories.ProductRepository;

@Service
public class ProductsService implements ProductRepository {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Products> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return productRepository.findAll(sort);
	}

	@Override
	public List<Products> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Products> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Products getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Products> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Products> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> S save(S entity) {
		// TODO Auto-generated method stub
		return productRepository.save(entity);
	}

	@Override
	public Optional<Products> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	public Optional<Products> findByName(String name){
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Products entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll(Iterable<? extends Products> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Products> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Products> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Products> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Products> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteInBatch(Iterable<Products> entities) {
		// TODO Auto-generated method stub
		
	}
}
