package com.faith.converter;

import com.faith.entity.Vendor;
import com.faith.model.VendorModel;

public class VendorConverter {

	//toEntiry conversion for vendor 
	public static Vendor toEntity(VendorModel vendorModel) {
		Vendor ven = new Vendor();
		ven.setvId(vendorModel.getvId());
		ven.setvName(vendorModel.getvName());
		ven.setAddress(vendorModel.getAddress());
		ven.setLocation(vendorModel.getLocation());
		ven.setService(vendorModel.getService());
		ven.setPincode(vendorModel.getPincode());
		ven.setIsActive(vendorModel.getIsActive());
		return ven;
	}

	//toModel Conversion for vendor 
	public static VendorModel toModel(Vendor vendor) {
		VendorModel vendorModel = new VendorModel();
		vendorModel.setvId(vendor.getvId());
		vendorModel.setvName(vendor.getvName());
		vendorModel.setAddress(vendor.getAddress());
		vendorModel.setLocation(vendor.getLocation());
		vendorModel.setService(vendor.getService());
		vendorModel.setPincode(vendor.getPincode());
		vendorModel.setIsActive(vendor.getIsActive());
		return vendorModel;
	}
}
