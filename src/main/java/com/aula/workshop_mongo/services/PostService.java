package com.aula.workshop_mongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.workshop_mongo.domain.Post;
import com.aula.workshop_mongo.repositories.PostRepository;
import com.aula.workshop_mongo.services.exceptions.ObjectNotFounException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFounException("Post não encontrado"));
	}
	
}