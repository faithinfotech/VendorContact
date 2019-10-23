package com.faith.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.faith.dao.AbstractDao;
import com.faith.dao.ContactDao;
import com.faith.entity.Contact;

@Repository
public class ContactDaoImpl extends AbstractDao implements ContactDao {

	// To get all contact details
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Contact.class);
		criteria.addOrder(Order.desc("cId"));
		return (List<Contact>) criteria.list();
	}

	// To insert contact details
	@Override
	public void saveContact(Contact contact) {
		// TODO Auto-generated method stub
		persist(contact);
	}

	// Update contact details
	@Override
	public void updateContact(Contact contact) {
		// TODO Auto-generated method stub
		getSession().update(contact);
	}

	// Delete the contact
	@Override
	public void deleteContact(int cId) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(
				"delete from contact where cId =:cId");
		query.setInteger("cId", cId);
		query.executeUpdate();
	}

	// Get contact details using contact Id
	@Override
	public Contact getById(int cId) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Contact.class);
		criteria.add(Restrictions.eq("cId", cId));
		criteria.setMaxResults(1);
		return (Contact) criteria.uniqueResult();
	}

	// To search contact department
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> search(String department) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Contact.class);
		criteria.add(Restrictions.eq("department", department));
		return (List<Contact>) criteria.list();

	}

}
