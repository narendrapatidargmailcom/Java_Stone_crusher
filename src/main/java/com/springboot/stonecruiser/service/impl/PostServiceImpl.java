package com.springboot.stonecruiser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.stonecruiser.dto.PostDto;
import com.springboot.stonecruiser.entity.Post;
import com.springboot.stonecruiser.repository.PostRepository;
import com.springboot.stonecruiser.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;
	
//	@Autowired
//	private ModelMapper modelmapper;
	
//	@Autowired
//	private CategoryRepository categoryRepository;

	@Override
	public Post savePost(PostDto postDto) {
	
		Post post = new Post();
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		Post newPost = postRepo.save(post);

		return newPost;
	}

	@Override
	public List<Post> getAllPosts() {
		List<Post> posts =postRepo.findAll();
		return posts;
	}
}
