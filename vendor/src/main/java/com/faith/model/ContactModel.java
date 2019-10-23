package com.faith.model;

public class ContactModel {
	private int cId;
	private String cName;
	private String department;
	private String email;
	private long phone;
	private Integer vId;
	private VendorModel vendor;

	// getters and setters
	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public VendorModel getVendor() {
		return vendor;
	}

	public void setVendor(VendorModel vendor) {
		this.vendor = vendor;
	}

}
