package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategoryService{
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	public void deleteCategory(Integer categoryDto);
	
	public CategoryDto getCategory(Integer categoryId);
	
	List<CategoryDto> getCategories();
}
