package com.Cart;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	
	@Autowired
	private CartService service;
	
	@GetMapping("/cart")
    public List<Cart> list() {
	     return service.listAll();
	}
	
	@GetMapping("/cart/{id}")
	public ResponseEntity <Cart> get(@PathVariable Integer id) {
		try {
			Cart cartItem = service.get(id);
			return new ResponseEntity<Cart>(cartItem, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/cart/addtocart")
	public void add(@RequestBody Cart cartItem) {
		service.save(cartItem);
	}
	
	@PutMapping("/cart/{id}")
		public ResponseEntity<Cart> update(@RequestBody Cart cartItem, @PathVariable Integer id) {
		try {
		service.update(id, cartItem);
		return new ResponseEntity<Cart>(cartItem, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/cart/{id}")
	public void delete (@PathVariable Integer id) {
		service.delete(id);
	}

}