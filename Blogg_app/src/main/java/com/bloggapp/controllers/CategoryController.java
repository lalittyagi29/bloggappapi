package com.bloggapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloggapp.payloads.ApiResponse;
import com.bloggapp.payloads.CategoryDto;
import com.bloggapp.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	//POST
	@PostMapping("/")
	public CategoryDto createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return createCategory;
	 }
	 
	//PUT
	@PutMapping("/{catId}")
	public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto , @PathVariable Integer catId) {
		
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);
		return updateCategory; 
	 }
	
	//DELETE
	@DeleteMapping("/{catId}")
	public  ApiResponse deleteCategoryByID(@PathVariable Integer catId) {
		
		this.categoryService.deleteCategory(catId);
		return new ApiResponse("Category deleted Sucessfully", true);
		
		 
	 }
	
	//GETBYID
	@GetMapping("/{catId}")
	 public CategoryDto getCategoryByID(@PathVariable Integer catId) {
		
		CategoryDto categoryById = this.categoryService.getCategoryById(catId);
		return categoryById;
		 
	 }
	 
	 //GetALL
	@GetMapping("/")
	public List<CategoryDto> getAllCategory() {
		
		List<CategoryDto> allCategory = this.categoryService.getAllCategory();
		return allCategory;	 
	 }

}
