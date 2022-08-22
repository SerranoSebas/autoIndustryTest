package com.autoindustry.backend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autoindustry.backend.entities.Users;
import com.autoindustry.backend.repositories.UserRepository;


@RestController
@RequestMapping(path="/Users")
@CrossOrigin("*")
public class UserREST {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Users add(@RequestBody Users user) throws Exception {
		return this.userRepository.save(user);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public Iterable<Users> views(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/find/{id}", method = RequestMethod.GET)
	public Optional<Users> view(@PathVariable Long id){
		if(userRepository.findById(id) != null) {
			return userRepository.findById(id);
		}
		return null;
	}
	
}
