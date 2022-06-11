package com.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.blog.exeptions.ResourceNotFoundExeption;
import com.blog.models.Posts;
import com.blog.repository.PostsRepository;

@Service
public class PostServices {
	@Autowired
	private PostsRepository postsRepository;
	
	
	public List<Posts> getAllPosts(){
		return postsRepository.findAll();
	}
	

	public Posts createPost(Posts post) {
		return postsRepository.save(post);	
	}

	
	public ResponseEntity<Posts> getPostById(Long id) {
		Posts post=postsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Post not exist with id"+id)); 
		return ResponseEntity.ok(post);
	}
	
	
	public Posts updatePost(Posts post) {
		return postsRepository.save(post);		
	}
	
	public void deletePost(Long postID) {		
		postsRepository.deleteById(postID);
	}

}
