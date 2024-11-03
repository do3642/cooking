package com.example.cooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cooking.domain.Client;

@Repository
public interface UserRepository extends JpaRepository<Client, Integer>{

	Optional<Client> findByUsername(String username);
	
	
}