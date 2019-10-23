package com.faith.dao;

import java.util.List;

import com.faith.entity.Vendor;

public interface VendorDao {
	public List<Vendor> getAll();

	public int saveVendor(Vendor vendor);

	public void updateVendor(Vendor vendor);

	public void deleteVendor(int vId);

	public Vendor getById(int vId);

	public int getVid();

}
