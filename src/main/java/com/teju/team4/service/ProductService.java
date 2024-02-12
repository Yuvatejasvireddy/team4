package com.teju.team4.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.teju.team4.model.Product;
import com.teju.team4.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	public ProductRepository prepo;
	
	public void addProduct(Product p)
	{
		prepo.save(p);
		
		
	}
	
	public void updateProduct(Product p)
	{
		prepo.save(p);
		
	}

	public Optional<Product> findById(Long id) {
		return prepo.findById(id);
	}

	public void delete(Product p) {
		prepo.delete(p);
		
	}
	
	
	
}
