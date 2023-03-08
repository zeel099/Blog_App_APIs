package com.blog.services;

import java.util.List;

import com.blog.entity.Post;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;



public interface PostService {
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	void deletePost(Integer postId);
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir,String imageName);
	
	PostDto getPostById(Integer postId);
	
	List<PostDto>getPostsByCategory(Integer categoryId);
	
	List<PostDto>getPostsByUser(Integer userId);
	
	List<PostDto>searchPosts(String keyword);
}
