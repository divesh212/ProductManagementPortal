package com.nagarro.yourmartapi.repository;

import java.util.List;

import com.nagarro.yourmartapi.model.Image;

public interface ImageRepository {
	List<Image> getImages(int productId);

	void save(Image image);
}