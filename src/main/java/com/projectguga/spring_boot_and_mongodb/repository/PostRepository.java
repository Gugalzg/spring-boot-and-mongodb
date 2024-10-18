package com.projectguga.spring_boot_and_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projectguga.spring_boot_and_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
