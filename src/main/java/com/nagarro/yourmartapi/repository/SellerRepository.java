package com.nagarro.yourmartapi.repository;

import java.util.List;

import com.nagarro.yourmartapi.model.Seller;

public interface SellerRepository {

	void save(Seller seller);
	List<Seller> getAllSeller(int offset,int limit);
	Seller authenticate(int sellerId, String password);
}