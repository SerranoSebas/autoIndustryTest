package com.autoindustry.backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.autoindustry.backend.entities.Inventory;
import com.autoindustry.backend.repositories.InventoryRepository;

@Service
public class InventoryService implements InventoryRepository {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public List<Inventory> findAll() {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll();
	}

	@Override
	public List<Inventory> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll(sort);
	}

	@Override
	public List<Inventory> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Inventory> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Inventory> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Page<Inventory> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Inventory> S save(S entity) {
		// TODO Auto-generated method stub
		return inventoryRepository.save(entity);
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
		inventoryRepository.deleteById(id);;
	}

	@Override
	public void delete(Inventory entity) {
		// TODO Auto-generated method stub
		inventoryRepository.delete(entity);
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Inventory> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Inventory> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Inventory> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Inventory> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll(Iterable<? extends Inventory> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Inventory> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Inventory> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Inventory> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Inventory> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Inventory> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Inventory> findProductById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	public Iterable<Inventory> findAllByProduct(String text) {
		// TODO Auto-generated method stub
		return inventoryRepository.findAllByProduct(text);
	}




}
