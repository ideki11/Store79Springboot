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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.models.Product;
import com.example.product.models.dto.CategoryDTO;
import com.example.product.models.dto.ProductDTO;
import com.example.product.repositories.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("/readall")
	public Map<String, Object> getAll(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Product> listPrdocut =  productRepo.findAll();
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		
		for (Product productEntity : listPrdocut) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(productEntity.getProductId());
			productDTO.setProductName(productEntity.getProductName());
			productDTO.setDescription(productEntity.getDescription());
			
			CategoryDTO categoryDto = new CategoryDTO();
			categoryDto.setCategoryId(productEntity.getCategories().getCategoryId());
			categoryDto.setCategoryName(productEntity.getCategories().getCategoryName());
			categoryDto.setDescription(productEntity.getCategories().getDescription());
			
			productDTO.setCategories(categoryDto);
			
			listProductDTO.add(productDTO);
		}
		
		result.put("message", "Read All Data Success");
		result.put("data", listProductDTO);
		result.put("total", listProductDTO.size());
		
		return result;
	}
	
	@PostMapping("/create")
	public Map<String, Object> createProduct(@Valid @RequestBody Product body){
		Map<String, Object> result = new HashMap<String, Object>();
		Product product = productRepo.save(body);
		
		result.put("message", "Success Create Product");
		result.put("data", product);
		
		return result;
	}
	
	@PutMapping("/update")
	public Map<String, Object> updateProduct(@Param("productid") Long productid, @Valid @RequestBody Product body){
		Map<String, Object> result = new HashMap<String, Object>();
		Product product = productRepo.findById(productid).get();
		product.setProductName(body.getProductName());
		product.setPrice(body.getPrice());
		product.setDescription(body.getDescription());
		product.setCategories(body.getCategories());
		
		productRepo.save(product);
		
		result.put("message", "Success Update Product");
		result.put("data", product);
		
		return result;
	}
}
