package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.InsufficientQuantity;
import com.masai.exception.ProductException;
import com.masai.model.Customer;
import com.masai.model.OrderDto;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@PostMapping("customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		
		
		Customer cusObj = cService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(cusObj,HttpStatus.CREATED);
	}
	
	@GetMapping("products/{customerId}/{productId}/{quantity}")
	public ResponseEntity<OrderDto> purchaseProduct(@PathVariable Integer customerId,@PathVariable Integer productId,@PathVariable Integer quantity) throws CustomerException, ProductException, InsufficientQuantity{
		
		OrderDto orderDto = cService.buyProduct(customerId, productId, quantity);
		
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
	}
	
	
	
}
