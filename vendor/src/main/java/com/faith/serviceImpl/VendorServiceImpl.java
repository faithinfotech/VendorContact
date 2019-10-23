package com.faith.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.converter.VendorConverter;
import com.faith.dao.VendorDao;
import com.faith.entity.Vendor;
import com.faith.model.VendorModel;
import com.faith.service.VendorService;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorDao vdao;

	// To get vendor by vendor Id
	@Override
	public VendorModel findById(int vId) {
		// TODO Auto-generated method stub
		return VendorConverter.toModel(vdao.getById(vId));
	}

	// To insert vendor
	@Override
	public int saveVen(VendorModel vendor) {
		// TODO Auto-generated method stub
		Vendor ven = VendorConverter.toEntity(vendor);
		System.out.println("vendor service:" + vendor);
		return vdao.saveVendor(ven);
	}

	// To get all vendors
	@Override
	public List<VendorModel> findAll() {
		// TODO Auto-generated method stub
		List<VendorModel> list = new ArrayList<VendorModel>();
		List<Vendor> venlist = vdao.getAll();
		System.out.println("venlist:" + venlist);
		for (Vendor ven : venlist) {
			list.add(VendorConverter.toModel(ven));
		}
		System.out.println("list:" + list);
		return list;
	}

	// To update vendor
	@Override
	public void updateVen(VendorModel vendor) {
		// TODO Auto-generated method stub
		vdao.updateVendor(VendorConverter.toEntity(vendor));
	}

	/*
	 * @Override public void disableById(int vId) { // TODO Auto-generated
	 * method stub vdao.disable(vId); }
	 */

	// To delete vendor by using vendor Id
	@Override
	public void deleteById(int vId) {
		// TODO Auto-generated method stub
		vdao.deleteVendor(vId);
	}

	// To get max(vId)
	public int find() {
		return (vdao).getVid();
	}

}
