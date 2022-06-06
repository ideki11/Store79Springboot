package com.example.product.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.models.Suppliers;
import com.example.product.models.dto.SupplierDTO;
import com.example.product.repositories.SuppliersRepository;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
	@Autowired
	SuppliersRepository supplierRepo;
	
	@GetMapping("/readall")
	public Map<String, Object> getAll(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<Suppliers> listSupplierEntity = supplierRepo.findAll();
		List<SupplierDTO> listSupplierDTO = new ArrayList<SupplierDTO>();
		
		for (Suppliers suppliers : listSupplierEntity) {
			SupplierDTO supplierDTO = new SupplierDTO();
			supplierDTO.setSupplierId(suppliers.getSupplierId());
			supplierDTO.setCity(supplierDTO.getCity());
			supplierDTO.setSupplierName(suppliers.getSupplierName());
			
			listSupplierDTO.add(supplierDTO);
		}
		
		result.put("message", "Read All Data Success");
		result.put("data", listSupplierDTO);
		result.put("total", listSupplierDTO.size());
		
		return result;
	}
	
	@PostMapping("/create")
	public Map<String, Object> createSupplier(@Valid @RequestBody Suppliers body){
		Map<String, Object> result = new HashMap<String, Object>();
		Suppliers supplierEntity = supplierRepo.save(body);
		
		result.put("message", "Success Create Supplier");
		result.put("data", supplierEntity);
		
		return result;
	}
}

