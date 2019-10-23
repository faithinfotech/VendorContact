package com.faith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.model.LoginModel;
import com.faith.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	// To find login by using userId
	@RequestMapping(value = "/{userName}/{password}", method = RequestMethod.GET)
	public LoginModel login(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		return loginService.findUser(userName, password);
	}

	// To insert a new login details
	@RequestMapping(method = RequestMethod.POST)
	public LoginModel createLogin(@RequestBody LoginModel loginModel) {
		loginService.saveLogin(loginModel);
		return loginModel;
	}

}
