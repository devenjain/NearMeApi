package com.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;                   

@JsonIgnoreProperties(ignoreUnknown = true) 
public class BuisnessBean {

	private int id;
	private String createdTs;
	private String businessName;
	private String address;
	private String city;
	private boolean isActive;
	private boolean delivery;
	private Double latitude;
	private Double longitude;
	private Double distance;
	
	
	public Double getDistance() {
		return distance;
	}
//	public void setDistance(Double distance) {
//		this.distance = distance;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(String createdTs) {
		this.createdTs = createdTs;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDelivery() {
		return delivery;
	}
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
		
	}
	
	
}
