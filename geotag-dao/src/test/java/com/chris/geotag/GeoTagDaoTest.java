package com.chris.geotag;

import java.util.Date;

import com.chris.geotag.dao.GeoTagDaoImpl;
import com.chris.geotag.domain.GeoTag;

public class GeoTagDaoTest {
	public static void main(String[] args) {
		GeoTag gt = new GeoTag();
		
		gt.setDate(new Date());
		gt.setLatitude(1.123);
		gt.setLongitude(2.345);
		
		GeoTagDaoImpl gtd = new GeoTagDaoImpl();
		
		gtd.persist(gt);
	}
}
