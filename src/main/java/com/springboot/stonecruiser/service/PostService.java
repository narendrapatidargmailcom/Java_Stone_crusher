package com.springboot.stonecruiser.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.stonecruiser.dto.PostDto;
import com.springboot.stonecruiser.entity.Post;


@Service
public interface PostService {
   Post savePost(PostDto postDto);
   List<Post> getAllPosts();
 //  List<PostDto> getPostsByCategoryId(Long categoryId); 
}