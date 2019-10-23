package com.faith.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.converter.VendorConverter;
import com.faith.dao.ContactDao;
import com.faith.entity.Contact;
import com.faith.entity.Vendor;
import com.faith.model.ContactModel;
import com.faith.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao cdao;

	// Get by Contact Id
	@Override
	public ContactModel findById(int cId) {
		// TODO Auto-generated method stub
		return toModel(cdao.getById(cId));
	}

	// Insert Contact
	@Override
	public void saveCon(ContactModel contactModel) {
		// TODO Auto-generated method stub
		Contact con = toEntity(contactModel);
		cdao.saveContact(con);
		contactModel = findById(con.getcId());
	}

	// Get all contacts
	@Override
	public List<ContactModel> findAll() {
		// TODO Auto-generated method stub
		List<ContactModel> list = new ArrayList<ContactModel>();
		List<Contact> contactlist = cdao.getAll();
		for (Contact con : contactlist) {
			list.add(toModel(con));
		}
		return list;
	}

	// Update Contact
	@Override
	public void updateCon(ContactModel contactModel) {
		// TODO Auto-generated method stub
		cdao.updateContact(toEntity(contactModel));
	}

	// Delete Contact
	@Override
	public void deleteById(int cId) {
		// TODO Auto-generated method stub
		cdao.deleteContact(cId);
	}

	// To Search Contact
	public List<ContactModel> searchByFields(String department) {
		// TODO Auto-generated method stub
		List<ContactModel> list = new ArrayList<ContactModel>();
		List<Contact> list1 = cdao.search(department);
		for (Contact con : list1) {
			list.add(toModel(con));
		}
		return list;

	}

	// toEntity converting function
	private Contact toEntity(ContactModel ContactModel) {
		Contact con = new Contact();
		con.setcId(ContactModel.getcId());
		con.setcName(ContactModel.getcName());
		if (ContactModel.getvId() != null) {
			Vendor vendor = new Vendor();
			vendor.setvId(ContactModel.getvId());
			con.setVendor(vendor);
		}
		con.setDepartment(ContactModel.getDepartment());
		con.setEmail(ContactModel.getEmail());
		con.setPhone(ContactModel.getPhone());
		return con;
	}

	// toModel converting function
	private ContactModel toModel(Contact contact) {
		ContactModel con = new ContactModel();
		con.setcId(contact.getcId());
		con.setcName(contact.getcName());
		if (contact.getVendor() != null) {
			con.setvId(contact.getVendor().getvId());
			con.setVendor(VendorConverter.toModel(contact.getVendor()));
		}
		con.setDepartment(contact.getDepartment());
		con.setEmail(contact.getEmail());
		con.setPhone(contact.getPhone());

		return con;
	}

}
