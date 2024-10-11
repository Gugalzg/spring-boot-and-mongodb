package com.projectguga.spring_boot_and_mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectguga.spring_boot_and_mongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> finAll(){
		User alexia = new User("1", "Alexia", "alexia@gmail.com");
		User guga = new User ("2", "Guga", "guga@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(alexia, guga));
		
		return ResponseEntity.ok().body(list);
		
	}
}
