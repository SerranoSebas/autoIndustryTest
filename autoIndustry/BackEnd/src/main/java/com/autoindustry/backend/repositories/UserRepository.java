package com.autoindustry.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autoindustry.backend.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
