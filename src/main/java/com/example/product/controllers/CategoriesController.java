package com.example.product.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.models.Categories;
import com.example.product.models.dto.CategoryDTO;
import com.example.product.repositories.CategoriesRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	@Autowired
	CategoriesRepository categoriesRepo;
	
	@GetMapping("/readall")
	public Map<String, Object> getAll(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Categories> listCategories = categoriesRepo.findAll();
		List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
		
		for(Categories categoryEntity : listCategories) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategoryId(categoryEntity.getCategoryId());
			categoryDTO.setCategoryName(categoryEntity.getCategoryName());
			categoryDTO.setDescription(categoryEntity.getDescription());
			
			listCategoryDTO.add(categoryDTO);
		}
		
		result.put("message", "Read All Data Success");
		result.put("data", listCategoryDTO);
		result.put("total", listCategoryDTO.size());
		
		return result;
	}
	
	@PostMapping("/create")
	public Map<String, Object> createCategory(@Valid @RequestBody Categories body){
		Map<String, Object> result = new HashMap<String, Object>();
		Categories category = categoriesRepo.save(body);
		
		result.put("message", "Success Create Category");
		result.put("data", category);
		
		return result;
	}
	
	@GetMapping("/readbyid")
	public Map<String, Object> getByid(@Param("categoryid") Long categoryid){
		Map<String, Object> result = new HashMap<String, Object>();
		Categories category = categoriesRepo.findById(categoryid).get();
		CategoryDTO categoryDTO = new CategoryDTO();
		
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setCategoryName(category.getCategoryName());
		categoryDTO.setDescription(category.getDescription());
		
		
		result.put("message", "Read By Category ID");
		result.put("data", categoryDTO);
		
		return result;
	}
}
