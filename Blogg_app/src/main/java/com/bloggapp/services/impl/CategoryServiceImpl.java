package com.bloggapp.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggapp.entities.Category;
import com.bloggapp.exceptions.ResourceNotFoundException;
import com.bloggapp.payloads.CategoryDto;
import com.bloggapp.repository.CategoryRepo;
import com.bloggapp.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
	    Category savedCategory=this.categoryRepo.save(this.dtoToCategory(categoryDto));
		return this.categoryToDto(savedCategory);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category byId = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		//Category byId = this.categoryRepo.getById(categoryId);
		byId.setCategoryAbout(categoryDto.getCategoryAbout());
		byId.setCategoryTitle(categoryDto.getCategoryTitle());
		Category save = this.categoryRepo.save(byId);
		return this.categoryToDto(save);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		
     	Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		return this.categoryToDto(cat);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
	    List<Category> findAll = this.categoryRepo.findAll();
	    List<CategoryDto> catDtoList=new ArrayList<>();
	    for (Category category : findAll) {
	    	CategoryDto categoryToDto = this.categoryToDto(category);
	    	catDtoList.add(categoryToDto);	
		}
		return catDtoList;
	}
	
	/*
	 * >>>These two method will be replace by modelMapper Library in future..
	 * >>>Here This is just for Learning Purpose..
	 * */
	public CategoryDto categoryToDto(Category category) {
		
		CategoryDto categoryDto =new CategoryDto();
		categoryDto.setCategoryAbout(category.getCategoryAbout());
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryTitle(category.getCategoryTitle());
		return categoryDto;
	
	}
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		
		Category category=new Category();
		category.setCategoryAbout(categoryDto.getCategoryAbout());
		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		return category;
	}

}
