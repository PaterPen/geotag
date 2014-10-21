package com.chris.geotag.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.chris.geotag.domain.GeoTag;

public class GeoTagDaoImpl implements GeoTagDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("geotag");
	EntityManager em = emf.createEntityManager();
	
	public void persist(Object o) {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}

	public void delete(Object o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
		
	}

	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	public GeoTag find(long id) {
		GeoTag gt = em.find(GeoTag.class, id);
		return gt;
	}
}
