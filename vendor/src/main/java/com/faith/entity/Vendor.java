package com.faith.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vId;

	private String vName;

	private String address;

	private String location;

	private String service;

	@Column(nullable = true)
	private int pincode;

	@Column(nullable = false)
	private String isActive;

	public Vendor() {
	}

	public Vendor(int vId, String vName, String address, String location,
			String service, int pincode, String isActive) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
	}

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

	// toString function
	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vName=" + vName + ", address="
				+ address + ", location=" + location + ", service=" + service
				+ ", pincode=" + pincode + ", isActive=" + isActive + "]";
	}

}
