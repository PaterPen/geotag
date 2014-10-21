package com.chris.geotag.service;

import com.chris.geotag.domain.GeoTag;

public interface GeoTagService {
	public boolean createGeoTag(double latitude, double longitude);
	
	public GeoTag getGeoTag(long id);
	
	public void deleteGeoTag(long id);
}
