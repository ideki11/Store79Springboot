package com.example.product.models.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.example.product.models.Product;

public class SupplierDTO {
	private Long supplierId;
	
	private String supplierName;
	
	private String city;
	
	public SupplierDTO() {
		// TODO Auto-generated constructor stub
	}

	public SupplierDTO(Long supplierId, String supplierName, String city) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
