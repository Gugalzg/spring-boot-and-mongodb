package com.projectguga.spring_boot_and_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projectguga.spring_boot_and_mongodb.domain.Post;
import com.projectguga.spring_boot_and_mongodb.domain.User;
import com.projectguga.spring_boot_and_mongodb.dto.AuthorDTO;
import com.projectguga.spring_boot_and_mongodb.dto.CommentDTO;
import com.projectguga.spring_boot_and_mongodb.repository.PostRepository;
import com.projectguga.spring_boot_and_mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;	
	
	@Autowired
	private PostRepository postRepository;	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User alexia = new User(null, "Alexia Milles", "alexia@gmail.com");
		User guga = new User(null, "Guga", "guga@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");
	
		userRepository.saveAll(Arrays.asList(alexia, guga, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO (alexia));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO (alexia));

		CommentDTO c1 = new CommentDTO("Bom viagem!", sdf.parse("21/03/2018"), new AuthorDTO(guga));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(bob));
		
		post1.getCommets().addAll(Arrays.asList(c1, c2));
		post2.getCommets().addAll(Arrays.asList(c3));

		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		alexia.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(alexia);
	}
}
