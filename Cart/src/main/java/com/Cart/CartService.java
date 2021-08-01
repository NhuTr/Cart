package com.Cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
	private CartRepository repo;
	
	public List<Cart> listAll(){
		return repo.findAll();	
		}
	
	public void save(Cart cartItem) {
		repo.save(cartItem);
	}
	
	public Cart get(Integer id) {
		return repo.findById(id).get();
		}
	public void update(Integer id, Cart cartItem) {
		Cart cartdata = repo.findById(id).get();
		cartdata.setBook(cartItem.getBook());
		cartdata.setCategory(cartItem.getCategory());
		cartdata.setPrice(cartItem.getPrice());
		cartdata.setQuantity(cartItem.getQuantity());
		repo.save(cartdata);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
	

}