package com.teju.team4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teju.team4.repository.OrderRepository;
import com.teju.team4.model.Order;


@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;
	
	
	//getting orders by id of staff(deliveryagent)
	 public List<Order> getOrdersByStaffId(Long staffId) {
	        return orderRepository.findByStaff_StaffId(staffId);
	    }
	 
	 
        //updating status of order
	    public void updateOrderStatus(Long orderId, String status) {
	        Order order =  orderRepository.findById(orderId).orElse(null);
	        if (order != null) {
	           order.setStatus(status);
	            orderRepository.save(order);
	        }
	    }
	    
	    //getall products for manager
	    public List<Order> findAll()
	    {
	    	return orderRepository.findAll();
	    }

        //find order byId
		public Optional<Order> findById(Long orderId) {
			// TODO Auto-generated method stub
			return orderRepository.findById(orderId);
		}
	    
	   

}
