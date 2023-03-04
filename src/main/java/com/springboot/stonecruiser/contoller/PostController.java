package com.springboot.stonecruiser.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.stonecruiser.dto.PostDto;
import com.springboot.stonecruiser.entity.Post;
import com.springboot.stonecruiser.service.PostService;


@RestController 
@RequestMapping("/api/posts")
public class PostController {
   @Autowired
   private PostService postserv;
	
	@PostMapping
	public Post createPost(@RequestBody PostDto post) {
		return postserv.savePost(post);
	}
	
	@GetMapping
	public List<Post> getAllPosts() {
		return postserv.getAllPosts();
	}
}
