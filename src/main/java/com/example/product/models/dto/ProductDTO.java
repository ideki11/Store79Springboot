package com.example.product.models.dto;

public class ProductDTO {
	private Long productId;
	private String productName;
	private String description;
	private CategoryDTO categories;
	private SupplierDTO suppliers;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Long productId, String productName, String description, CategoryDTO categories, SupplierDTO suppliers) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.categories = categories;
		this.suppliers = suppliers;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryDTO getCategories() {
		return categories;
	}

	public void setCategories(CategoryDTO categories) {
		this.categories = categories;
	}

	public SupplierDTO getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(SupplierDTO suppliers) {
		this.suppliers = suppliers;
	}
	
}
