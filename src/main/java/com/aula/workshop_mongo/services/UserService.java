package com.aula.workshop_mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.workshop_mongo.domain.User;
import com.aula.workshop_mongo.repositories.UserRepository;
import com.aula.workshop_mongo.services.exceptions.ObjectNotFounException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFounException("Usuário não encontrado"));
	}

}
