package com.nagarro.yourmartapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.yourmartapi.model.Product;

@Repository
@Transactional
public class HibernateProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	private EntityManager em;
	
	@Override
	public void save(Product product) {
		em.persist(product);
	}

	@Override
	public Product getProduct(int id) {
		return em.find(Product.class, id);
	}
	
	@Override
	public List<Product> getAllProduct() {
		Query query = em.createQuery("SELECT p FROM Product p");
		return (List<Product>)query.getResultList();
	}
	
	@Override
	public Product updateProduct(Product product) {
		return em.merge(product);
	}

	@Override
	public void deleteProduct(int id) {
		Query query = em.createQuery("DELETE FROM Product p WHERE p.id = :id");
		int i = query.setParameter("id", id).executeUpdate();
	}

}
