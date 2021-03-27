package com.example.PostService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.PostService.model.Post;
import com.example.PostService.repository.PostRepository;

@Component
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post getPostById(int id) {
		Post post = new Post();
		post = postRepository.getPostById(id);
		if( post != null)
			return post;
		else
			return null;
	}

}
