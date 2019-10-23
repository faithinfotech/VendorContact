package com.faith.service;

import com.faith.model.LoginModel;

public interface LoginService {
	public LoginModel findUser(String uName, String password);

	public void saveLogin(LoginModel login);
}
