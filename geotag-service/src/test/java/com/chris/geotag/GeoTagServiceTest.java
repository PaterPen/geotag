package com.chris.geotag;

import com.chris.geotag.domain.GeoTag;
import com.chris.geotag.service.GeoTagServiceImpl;

public class GeoTagServiceTest {

	public static void main(String[] args) {
		GeoTagServiceImpl gts = new GeoTagServiceImpl();
		GeoTag gt;
		
		gts.createGeoTag(1.234, 5.678);
		
		gt = gts.getGeoTag(1);
		System.out.print(gt.toString());
		
		gts.deleteGeoTag(1);
		
	}

}
