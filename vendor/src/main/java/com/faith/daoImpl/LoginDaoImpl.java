package com.faith.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.faith.dao.AbstractDao;
import com.faith.dao.LoginDao;
import com.faith.entity.Login;

@Repository
public class LoginDaoImpl extends AbstractDao implements LoginDao {

	// To get all user names and passwords
	public Login getAll(String userName, String password) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Login.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		criteria.setMaxResults(1);
		return (Login) criteria.uniqueResult();
	}

	// To insert user name and password
	@Override
	public void save(Login login) {
		// TODO Auto-generated method stub
		persist(login);
	}

}
