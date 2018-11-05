package com.nagarro.yourmartapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.model.Image;

/**
 * @author diveshjethani
 *
 */
@Transactional
@Repository
public class HibernateImageRepositoryImpl implements ImageRepository {
	@Autowired
	private EntityManager em;

	
	/**
	 * @param productId
	 * @return
	 */
	@Override
	public List<Image> getImages(int productId) {
		Query query = em.createQuery("SELECT i FROM Image i WHERE i.product.id = '" + productId + "'");
		return (List<Image>) query.getResultList();
	}
	
	/**
	 * @param image
	 */
	@Override
	public void save(Image image) {
		em.persist(image);
	}

	@Override
	public void uploadImage(Image image) {
		em.persist(image);
	}
}