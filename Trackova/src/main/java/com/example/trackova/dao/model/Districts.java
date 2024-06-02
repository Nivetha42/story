package com.example.trackova.dao.model;


public class Districts {
	int districtId;
	String name;
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int stateId) {
		this.districtId = stateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Districts(int districtId, String name) {
		super();
		this.districtId = districtId;
		this.name = name;
	}
	
	
}
