package com.project.main.domain;

import java.util.Optional;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @JsonIgnore
	private Long id;

	@NotNull(message = "Name is required")
	@Size(max = 250, message = "name can't be longer than 250 characters")
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull(message = "Price is Required")
	@Column(name = "price", nullable = false)
	private double price;

	@NotNull
	@Column(name = "quantity", nullable = false)
	private int quantity;

	public Product() {
	}

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return "{ id=" + getId() + ", name=" + getName() + ", price=" + getPrice() + ", quantity=" + getQuantity()
				+ "}";
	}

}