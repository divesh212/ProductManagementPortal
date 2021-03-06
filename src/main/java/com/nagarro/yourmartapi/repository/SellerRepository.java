package com.nagarro.yourmartapi.repository;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.yourmartapi.model.Seller;

public interface SellerRepository {

	void save(Seller seller);
	List<Seller> getAllSeller(int offset,int limit,String sortBy, String filter,String searchKey,String searchQuery);
	Seller authenticate(int sellerId, String password);
	void setStatus(int i,String value);
	ArrayList<Integer> getAllSellerId();
	ArrayList<String> getAllSellerCampanyName();
	Seller getSeller(int id);
	Boolean isAuthenticatedByToken(int id, String token);
	Long totalSeller();
}