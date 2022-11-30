package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer productId;
	
	@NotBlank
	private String name;
	
	@NotNull
	private Double price;
	
	@NotNull
	@Min(1)
	private Integer quantity;
	
	private String productType;
	
	private String description;
	
	
	private Double rating;

	
	
	@OneToMany(cascade =  CascadeType.ALL, mappedBy = "product")
	private List<ProductReview> list = new ArrayList<>();
	
	
	
}
