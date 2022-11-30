package com.masai.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.InsufficientQuantity;
import com.masai.exception.ProductException;
import com.masai.model.Customer;
import com.masai.model.OrderDto;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.model.Status;
import com.masai.repository.CustomerRepo;
import com.masai.repository.OrderDtoRepo;
import com.masai.repository.OrderRepo;
import com.masai.repository.ProductRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private OrderRepo oRepo;
	
	@Autowired
	private ProductRepo pRepo;
	
	@Autowired
	private OrderDtoRepo oDtoRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		
		return  cRepo.save(customer);
		
	}

	@Override
	public OrderDto buyProduct(Integer customerId, Integer productId, Integer quantity) throws CustomerException,ProductException,InsufficientQuantity {
		
		 Optional<Customer> opt = cRepo.findById(customerId);
		
		if(opt.isPresent()) {
			
			Optional<Product> productOpt = pRepo.findById(productId);
			
			if(productOpt.isPresent()) {
				
				if(quantity > productOpt.get().getQuantity()) {
					throw new InsufficientQuantity("Your quantity is greater than available stock your quantity "+quantity+" avialable quantity "+productOpt.get().getQuantity()+" ");
				}else {
					
					Orders order = new Orders();
					order.setPurchaseDate(LocalDate.now());
					order.setPurchaseTime(LocalTime.now());
					order.setCustomerId(customerId);
					order.setProductId(productId);
					order.setProductQuantity(quantity);
					order.setPrice(quantity * productOpt.get().getPrice());
					order.setStatus(Status.PENDING);
					Status s = Status.PENDING;
					
					
					oRepo.save(order);
					///////////////////////////////////////////
					
					OrderDto orderDto = new OrderDto();
					orderDto.setCustomerId(customerId);
					orderDto.setName(productOpt.get().getName());
//					orderDto.setPrice(quantity*productOpt.get().getPrice());
					double p = quantity * productOpt.get().getPrice();
//					orderDto.setPrice(p);)
					orderDto.setProductId(productId);
					orderDto.setQuantity(quantity);
					
					OrderDto obj = oDtoRepo.save(orderDto);
					return obj;
				}
				
			}else {
				
				throw new ProductException("product does not exist with this ProductId");
				
			}
			
		}else {
			
			throw new CustomerException("customer does not exist with this ID");
		}
		 
		 
		
	}
	
	
	
	
}
