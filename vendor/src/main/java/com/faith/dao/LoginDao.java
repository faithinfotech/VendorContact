package com.faith.dao;

import com.faith.entity.Login;

public interface LoginDao {

	public Login getAll(String uName, String password);

	public void save(Login login);

}
