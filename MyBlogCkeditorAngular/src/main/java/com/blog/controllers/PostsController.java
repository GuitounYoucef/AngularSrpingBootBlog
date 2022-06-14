package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.blog.repository.PostsRepository;
import com.blog.services.PostServices;
import com.blog.exeptions.ResourceNotFoundExeption;
import com.blog.models.Posts;

@CrossOrigin
@RestController
@RequestMapping("/blog/")
public class PostsController {
	
	@Autowired
	private PostServices postServices;
	
	
	
	@GetMapping("/testblog")
	public String getmessage() {
		return "Test Blog message work!!";
	}
	

	@GetMapping("/posts")
	public List<Posts> getAllPosts(){
		return postServices.getAllPosts();
	}
	

	@PostMapping("/posts")
	public Posts createPost(@RequestBody Posts post) {
		return postServices.createPost(post);	
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
		return postServices.getPostById(id);
	}
	

	@PutMapping("/posts")
	public Posts updatePost(@RequestBody Posts post) {
		return postServices.updatePost(post);	
	}	
	
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable Long id) {
		return postServices.deletePost(id);
	}	
	

}
