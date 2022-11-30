package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.exception.InsufficientQuantity;
import com.masai.exception.ProductException;
import com.masai.model.Customer;
import com.masai.model.OrderDto;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public OrderDto buyProduct(Integer customerId,Integer productId,Integer quantity) throws CustomerException,ProductException,InsufficientQuantity;
	
	
	
}
