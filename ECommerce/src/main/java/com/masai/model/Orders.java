package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer orderId;
	
	private LocalDate purchaseDate;
	
	private LocalTime purchaseTime;
	
	private Integer productId;
	
	private Integer productQuantity;
	
	private LocalDate deliveryDate;
	
	private Double price;
	
	private Integer customerId;
	
	private Status status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

}
