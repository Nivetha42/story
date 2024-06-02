package com.example.trackova.dao.model;

public class States {
	int stateId;
	String name;
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public States(int stateId, String name) {
		super();
		this.stateId = stateId;
		this.name = name;
	}
	
}
