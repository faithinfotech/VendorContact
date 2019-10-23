package com.faith.service;

import java.util.List;

import com.faith.model.ContactModel;

public interface ContactService {
	ContactModel findById(int cId);

	void saveCon(ContactModel contactModel);

	List<ContactModel> findAll();

	void updateCon(ContactModel contactModel);

	void deleteById(int cId);

	List<ContactModel> searchByFields(String department);

}
