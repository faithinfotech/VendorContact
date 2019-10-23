package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.model.VendorModel;
import com.faith.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	// To insert
	@RequestMapping(method = RequestMethod.GET)
	public List<VendorModel> list() {
		return vendorService.findAll();
	}

	// To get by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public VendorModel vendor(@PathVariable("id") int vId) {
		return vendorService.findById(vId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public VendorModel createVendor(@RequestBody VendorModel vendorModel) {
		System.out.println(vendorModel);
		vendorService.saveVen(vendorModel);
		return vendorModel;
	}

	// To update
	@RequestMapping(method = RequestMethod.PUT)
	public VendorModel updateVendor(@RequestBody VendorModel vendorModel) {
		vendorService.updateVen(vendorModel);
		return vendorModel;
	}

	// To delete
	@RequestMapping(value = "/{vId}", method = RequestMethod.DELETE)
	public VendorModel delete(@PathVariable("vId") int vId) {
		VendorModel vendorModel = vendorService.findById(vId);
		vendorService.deleteById(vendorModel.getvId());
		return vendorModel;
	}

	// To get max(vId)
	@RequestMapping(value = "/max/vId", method = RequestMethod.GET)
	public int getMax() {
		return vendorService.find();

	}

}
