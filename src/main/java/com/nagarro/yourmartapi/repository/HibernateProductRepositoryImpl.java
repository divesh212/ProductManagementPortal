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
	public List<Product> getAllProduct(int offset,int limit,String sortBy,String searchKey, String searchQuery, String status, String category) {
		Query query = null;
		boolean isWhereRequired = true;
		String queryString = "SELECT p FROM Product p ";
		
		if(searchKey!=null) {
			String sq = searchKey.equals("name") ? "p.name" : "p.code" ;
			queryString += "WHERE " + sq + " = '" + searchQuery + "' ";
			isWhereRequired = false;
		}
		
		if(status!=null) {
			if(isWhereRequired) {
				queryString += "WHERE p.status = '" + status + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.status = '" + status + "' ";				
			}
		}
		if(category!=null) {
			if(isWhereRequired) {
				queryString += "WHERE p.category = '" + category + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.category = '" + category + "' ";				
			}
		}
		if(sortBy!=null) {
			queryString += "ORDER BY "+sortBy;
		}
		query = em.createQuery(queryString);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return (List<Product>)query.getResultList();
	}
	
	@Override
	public Product updateProduct(Product product) {
		return em.merge(product);
	}

	@Override
	public void deleteProduct(int id) {
		Query query = em.createQuery("DELETE FROM Product p WHERE p.id = :id");
		query.setParameter("id", id).executeUpdate();
	}

}
