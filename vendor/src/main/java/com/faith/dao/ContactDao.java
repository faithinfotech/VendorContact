package com.faith.dao;

import java.util.List;

import com.faith.entity.Contact;

public interface ContactDao {
	public List<Contact> getAll();

	public void saveContact(Contact contact);

	public void updateContact(Contact contact);

	public void deleteContact(int cId);

	public Contact getById(int cId);

	public List<Contact> search(String department);

}
