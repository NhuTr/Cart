package com.Cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cart_id;
	private String book;
	private String category;
	private Double price;
	private Integer quantity;
	
	
	
	public Cart() {
		
	}
	public Cart(Integer cart_id, String book,String category, Double price, Integer quantity) {
		super();
		this.cart_id = cart_id;
		this.book = book;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		
	}
	public Integer getCart_id() {
		return cart_id;
	}
	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	

	
}

