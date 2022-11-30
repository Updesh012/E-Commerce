package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.OrderDto;

@Repository
public interface OrderDtoRepo extends JpaRepository<OrderDto, Integer>{

}
