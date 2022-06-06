package com.example.product.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categories", schema = "public")
public class Categories implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_categories_category_id_seq")
	@SequenceGenerator(name = "generator_categories_category_id_seq", sequenceName = "categories_category_id_seq", allocationSize = 1)
	@Column(name = "category_id", nullable = false, unique = true)
	private Long categoryId;
	
	@Column(name = "category_name", nullable = false)
	private String categoryName;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "categories")
	List<Product> listProduct;
	
	public Categories() {
		// TODO Auto-generated constructor stub
	}

	public Categories(Long categoryId, String categoryName, String description, List<Product> listProduct) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.listProduct = listProduct;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
