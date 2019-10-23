package com.faith.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.faith.dao.AbstractDao;
import com.faith.dao.VendorDao;
import com.faith.entity.Vendor;

@Repository
public class VendorDaoImpl extends AbstractDao implements VendorDao {

	// Get all vendor details
	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> getAll() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Vendor.class);
		criteria.addOrder(Order.desc("vId"));
		return (List<Vendor>) criteria.list();
	}

	// To insert new vendor
	@Override
	public int saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		System.out.println("VendorDaoImpl:" + vendor);
		persist(vendor);
		Criteria criteria = getSession().createCriteria(Vendor.class)
				.setProjection(Projections.max("vId"));
		Integer vId = (Integer) criteria.uniqueResult();
		System.out.println("vId :" + vId);
		return vId;
	}

	// To update Vendor
	@Override
	public void updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		getSession().update(vendor);
	}


	// Get vendor details by using vendor Id
	@Override
	public Vendor getById(int vId) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Vendor.class);
		criteria.add(Restrictions.eq("vId", vId));
		criteria.setMaxResults(1);
		return (Vendor) criteria.uniqueResult();

	}

	// To delete vendor details
	@Override
	public void deleteVendor(int vId) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery(
				"delete from vendor where vId =:vId");
		query.setInteger("vId", vId);
		query.executeUpdate();

	}

	// To get max(vId)
	public int getVid() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Vendor.class)
				.setProjection(Projections.max("vId"));
		Integer vId = (Integer) criteria.uniqueResult();
		return vId;
	}

}
