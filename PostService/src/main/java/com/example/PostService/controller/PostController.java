package com.example.PostService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.PostService.model.Post;
import com.example.PostService.service.PostService;

@RestController
public class PostController {
	@Autowired
	private PostService postService;
	
	@GetMapping("/posts/{id}")
	public Post getPostByID(@PathVariable int id) {
		Post possiblePost = postService.getPostById(id);
		return possiblePost;
		
	}
	
}
