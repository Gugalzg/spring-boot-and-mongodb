package com.projectguga.spring_boot_and_mongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectguga.spring_boot_and_mongodb.domain.Post;
import com.projectguga.spring_boot_and_mongodb.repository.PostRepository;
import com.projectguga.spring_boot_and_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
	}
}
