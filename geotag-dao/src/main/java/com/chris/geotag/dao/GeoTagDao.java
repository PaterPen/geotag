package com.chris.geotag.dao;

import com.chris.geotag.domain.GeoTag;

public interface GeoTagDao {
	public void persist(Object o);
	
	public void delete(Object o);
	
	public void update(Object o);
	
	public GeoTag find(long id);
}
