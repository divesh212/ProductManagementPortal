package com.nagarro.yourmartapi.repository;

import com.nagarro.yourmartapi.model.Seller;

public interface SellerRepository {

	void save(Seller seller);
	Seller getAllSeller();

}