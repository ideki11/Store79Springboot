package com.example.product.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "suppliers", schema = "public")
public class Suppliers implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id", unique = true, nullable = false)
	private Long supplierId;
	
	@Column(name = "supplier_name", nullable = false)
	private String supplierName;
	
	@Column(name = "city")
	private String city;
	
	@OneToMany(mappedBy = "suppliers")
	List<Product> suppliers;
	
	public Suppliers() {
		// TODO Auto-generated constructor stub
	}	

	public Suppliers(Long supplierId, String supplierName, String city, List<Product> suppliers) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
		this.suppliers = suppliers;
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

	public List<Product> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Product> suppliers) {
		this.suppliers = suppliers;
	}
	
	
}
