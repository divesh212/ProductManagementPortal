package com.nagarro.yourmartapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.model.Seller;
import com.nagarro.yourmartapi.model.SellerLogin;
import com.nagarro.yourmartapi.repository.SellerRepository;

@RestController
public class SellerController {

	@Autowired
	private SellerRepository sellerRepository;

	@GetMapping("/seller")
	public List<Seller> getAllSeller(@RequestParam(value = "offset", required = false, defaultValue="0") int offset,
			@RequestParam(value = "limit", required = false, defaultValue="10") int limit) {
		return sellerRepository.getAllSeller(offset, limit);
	}

	@PostMapping(path = "/seller")
	public void addSeller(@RequestBody Seller seller) {
		System.out.println(seller);
		sellerRepository.save(seller);
	}
	
	@PostMapping(path = "/seller/login")
	public Seller login(@RequestBody SellerLogin sellerLogin) {
		Seller seller = sellerRepository.authenticate(sellerLogin.getid(),sellerLogin.getPassword());
		return seller;
	}

}
