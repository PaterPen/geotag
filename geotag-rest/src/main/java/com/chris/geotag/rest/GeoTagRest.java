package com.chris.geotag.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.chris.geotag.domain.GeoTag;
import com.chris.geotag.service.GeoTagServiceImpl;

@Path("/geotag")
public class GeoTagRest 
{
	GeoTagServiceImpl service = new GeoTagServiceImpl();
	
	@GET
	@Path("/get/{geoTagId}")
	public String getGeoTag(@PathParam("geoTagId") long id) {
		GeoTag gt = service.getGeoTag(id);
		return "{ id : \"" + gt.getId() + "\", latitude : \"" + gt.getLatitude() + "\", longitude : \"" + gt.getLongitude() + "\", date : \"" + gt.getDate() + "\" }";
	}
	
	@POST
	@Path("/create")
	public String createGeoTag(@FormParam("latitude") double latitude, @FormParam("longitude") double longitude) {
		boolean success = service.createGeoTag(latitude, longitude);
		
		if (success) {
			return "{ status : \"SUCCESS\" }";
		} else {
			return "{ status : \"ERROR\" }";
		}
	}
}
