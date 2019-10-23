package com.faith.service;

import java.util.List;

import com.faith.model.VendorModel;

public interface VendorService {
	VendorModel findById(int vId);

	int saveVen(VendorModel vendor);

	List<VendorModel> findAll();

	void updateVen(VendorModel vendor);

	void deleteById(int vId);

	int find();

}
