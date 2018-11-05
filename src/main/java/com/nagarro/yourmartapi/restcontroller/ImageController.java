package com.nagarro.yourmartapi.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.yourmartapi.model.Image;
import com.nagarro.yourmartapi.model.Product;
import com.nagarro.yourmartapi.repository.ImageRepository;

@RestController
@CrossOrigin
public class ImageController {
	@Autowired
	private ImageRepository imageRepository;

	@PostMapping(value = "/product/{id}/image")
	public void saveImages(@PathVariable("id") int productId,
								@RequestParam("image") MultipartFile imageFile) throws IOException {
		Image image = new Image();
		image.setImage(imageFile.getBytes());
		Product product = new Product();
		product.setId(productId);
		image.setProduct(product);
		imageRepository.uploadImage(image);
	}

	@GetMapping(value = "/product/{id}/image")
	public List<Image> getImages(@PathVariable("id") int productId) {
		List<Image> images = imageRepository.getImages(productId);
		return images;
	}
}