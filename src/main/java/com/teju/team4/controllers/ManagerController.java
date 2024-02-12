package com.teju.team4.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teju.team4.model.Order;
import com.teju.team4.model.Product;
import com.teju.team4.service.OrderService;
import com.teju.team4.service.ProductService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
   
	@Autowired
	public ProductService ps;
	
	@Autowired
	public OrderService os;
	//addproducts
	@PostMapping("/addproduct")
	 public ResponseEntity<String> addProduct(@RequestBody Product product) {
        ps.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }
	
	
	
	//update product
	@PatchMapping("/updateProduct/{id}")
	public void updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) throws NotFoundException {
	    
	    Product existingProduct = ps.findById(id).orElseThrow(NotFoundException::new);

	    if (existingProduct != null) {
	        
	        if (updatedProduct.getName() != null) {
	            existingProduct.setName(updatedProduct.getName());
	        }
	        
	        if (updatedProduct.getThumbnail() != null) {
	            existingProduct.setThumbnail(updatedProduct.getThumbnail());
	        }
	        
	        if (updatedProduct.getCat_id() != null) {
	            existingProduct.setCat_id(updatedProduct.getCat_id());
	        }
	       
	        if (updatedProduct.getPrice() != null) {
	            existingProduct.setPrice(updatedProduct.getPrice());
	        }
	        
	        if (updatedProduct.getDetails() != null) {
	            existingProduct.setDetails(updatedProduct.getDetails());
	        }
	        
	        if (updatedProduct.getQuantity() != null) {
	            existingProduct.setQuantity(updatedProduct.getQuantity());
	        }

	        ps.addProduct(existingProduct);
	    } else {
	        throw new NotFoundException();
	    }
	}

	
	//deleteproducts 
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Long id) throws NotFoundException
	{
		Product existingProduct = ps.findById(id).orElse(null);
		 if (existingProduct != null) {
	           
	           

	        
	            ps.delete(existingProduct);
	        } else {
	           
	            throw new NotFoundException();
	        }
		
	}
	
	//view order details
	 @GetMapping("/orders")
	    public ResponseEntity<List<Order>> getOrdersByDeliveryAgent() {
	        List<Order> orders = os.findAll();
	        return ResponseEntity.ok(orders);
	    }
	 
	 //Assigning Orders
	
	 
	
	 
}
