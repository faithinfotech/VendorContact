package com.faith.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.dao.LoginDao;
import com.faith.entity.Login;
import com.faith.model.LoginModel;
import com.faith.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao ldao;

	// To get login user name and password
	public LoginModel findUser(String userName, String password) {
		// TODO Auto-generated method stub
		return toLModel(ldao.getAll(userName, password));
	}

	// To insert user name and password
	public void saveLogin(LoginModel login) {
		// TODO Auto-generated method stub
		Login login_dt = toLEntity(login);
		ldao.save(login_dt);
	}

	// toEntity conversion
	private Login toLEntity(LoginModel loginModel) {
		Login log = new Login();
		log.setUserId(loginModel.getUserId());
		log.setUserName(loginModel.getUserName());
		log.setPassword(loginModel.getPassword());
		return log;
	}

	// toModel Conversion
	private LoginModel toLModel(Login log) {
		LoginModel loginModel = new LoginModel();
		loginModel.setUserId(log.getUserId());
		loginModel.setUserName(log.getUserName());
		loginModel.setPassword(log.getPassword());
		return loginModel;
	}

}
