package com.pack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dao.ILoginDao;
import com.pack.service.ILoginService;
@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	ILoginDao dao;

	public boolean doLogin(String username, String password) {
		return dao.findUser(username, password);
	}

}
