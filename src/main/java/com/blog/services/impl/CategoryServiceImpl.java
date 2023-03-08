package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Category;

import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;

import com.blog.repositories.CategoryRepo;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("category","Category Id",categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedcat,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","category Id",categoryId));
		this.categoryRepo.delete(cat);
				
	}
//	public void deleteUser(Integer userId) {
//		// TODO Auto-generated method stub
//		User user = this.userRepo.findById(userId).
//				orElseThrow(() -> new ResourceNotFoundException("User"," Id ",userId));
//		this.userRepo.delete(user);
//
//	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
		return this.modelMapper.map(cat,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto>catDtos = categories.stream().map((cat)->this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}
//	public List<UserDto> getAllUsers() {
//		// TODO Auto-generated method stub
//		
//		List<User> users = this.userRepo.findAll();
//		
//		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
//		return userDtos;
//	}
	
}
