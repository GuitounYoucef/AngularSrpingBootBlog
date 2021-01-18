package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.blog.repository.PostsRepository;
import com.blog.exeptions.ResourceNotFoundExeption;
import com.blog.models.Posts;


@RestController
@RequestMapping("/blog/")
public class PostsController {
	@Autowired
	private PostsRepository postRepository;
	@GetMapping("/testblog")
	public String getmessage() {
		return "Test Blog message work!!";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/posts")
	public List<Posts> getAllPosts(){
		return postRepository.findAll();
	}
	
    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/posts")
	public Posts createPost(@RequestBody Posts post) {
		return postRepository.save(post);	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
		Posts post=postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Post not exist with id"+id)); 
		return ResponseEntity.ok(post);
	}

}
