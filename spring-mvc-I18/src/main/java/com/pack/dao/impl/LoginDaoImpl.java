package com.pack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pack.dao.ILoginDao;
@Repository
public class LoginDaoImpl implements ILoginDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean findUser(String username, String password) {
		try
		{
			String pwdId=jdbcTemplate.queryForObject("select password from user_detailes where username=?", String.class,username);
			if(password.equals(pwdId)) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
		return false;
	}

}
}
