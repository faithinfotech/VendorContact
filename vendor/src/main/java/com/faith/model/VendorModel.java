package com.faith.model;

public class VendorModel {

	// instantiating variables
	private int vId;
	private String vName;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private String isActive;
	private int maxvId;

	// getters and setters
	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getMaxvId() {
		return maxvId;
	}

	public void setMaxvId(int maxvId) {
		this.maxvId = maxvId;
	}

	// toString function
	@Override
	public String toString() {
		return "VendorModel [vId=" + vId + ", vName=" + vName + ", address="
				+ address + ", location=" + location + ", service=" + service
				+ ", pincode=" + pincode + ", isActive=" + isActive
				+ ", maxvId=" + maxvId + "]";
	}

}
