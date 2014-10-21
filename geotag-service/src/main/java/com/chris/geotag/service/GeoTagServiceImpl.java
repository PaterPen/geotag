package com.chris.geotag.service;

import java.util.Date;

import org.hibernate.HibernateException;

import com.chris.geotag.dao.GeoTagDaoImpl;
import com.chris.geotag.domain.GeoTag;
import com.chris.geotag.logger.GeoTagLogger;

public class GeoTagServiceImpl implements GeoTagService {
	GeoTagDaoImpl geoTagDao = new GeoTagDaoImpl();
	
	public boolean createGeoTag(double latitude, double longitude) {
		boolean result = true;
		
		GeoTag gt = new GeoTag();
		gt.setLatitude(latitude);
		gt.setLongitude(longitude);
		gt.setDate(new Date());
		
		/*
		 * TODO:
		 * Try-catch hier an der Stelle richtig, oder doch lieber auf REST-Ebene?
		 * boolean flag, ja oder nein?
		 */
		
		try {
			geoTagDao.persist(gt);
		} catch (HibernateException e) {
			GeoTagLogger.log(GeoTagLogger.INFO, "Error while trying to persist.");
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	public GeoTag getGeoTag(long id) {
		GeoTag gt = geoTagDao.find(id);
		return gt;
	}

	public void deleteGeoTag(long id) {
		GeoTag gt = getGeoTag(id);
		
		if (!gt.equals(null)) {
			geoTagDao.delete(gt);
		}
	}
}
