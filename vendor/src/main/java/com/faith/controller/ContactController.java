package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.model.ContactModel;
import com.faith.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	// Get contact
	@RequestMapping(method = RequestMethod.GET)
	public List<ContactModel> list() {
		return contactService.findAll();
	}

	// Get By Id
	@RequestMapping(value = "/{cId}", method = RequestMethod.GET)
	public ContactModel vendor(@PathVariable("cId") int cId) {
		return contactService.findById(cId);
	}

	// Insert Contact
	@RequestMapping(method = RequestMethod.POST)
	public ContactModel createContact(@RequestBody ContactModel contactModel) {
		System.out.println(contactModel);
		contactService.saveCon(contactModel);
		System.out.println(contactModel);
		return contactModel;
	}

	// Update Contact
	@RequestMapping(method = RequestMethod.PUT)
	public ContactModel updateContact(@RequestBody ContactModel contactModel) {
		contactService.updateCon(contactModel);
		return contactModel;
	}

	// To delete
	@RequestMapping(value = "/{cId}", method = RequestMethod.DELETE)
	public ContactModel delete(@PathVariable("cId") int cId) {
		ContactModel contactModel = contactService.findById(cId);
		contactService.deleteById(contactModel.getcId());
		return contactModel;
	}

	// To search
	@RequestMapping(value = "/search/{department}", method = RequestMethod.GET)
	public List<ContactModel> searchField(
			@PathVariable("department") String department) {
		return contactService.searchByFields(department);
	}

}
