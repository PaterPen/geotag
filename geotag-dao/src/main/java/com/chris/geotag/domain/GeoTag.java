package com.chris.geotag.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geotag")
public class GeoTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;
	
	@Column(name="date")
	Date date;
	
	@Column(name="latitude")
	double latitude;

	@Column(name="longitude")
	double longitude;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public long getId() {
		return this.id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public String toString() {
		return "Id: " + this.id + ", Lat: " + this.latitude + ", Long: " + this.longitude + ", Date: " + this.date.toString();
	}
}
