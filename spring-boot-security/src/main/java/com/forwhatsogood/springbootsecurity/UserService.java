package com.forwhatsogood.springbootsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<UserDo> getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	public List<String> getPermissionsByUsername(String username) {
		return userDao.getPermissionsByUsername(username);
	}

	public List<String> getRoleByUsername(String username) {
		return userDao.getRoleByUsername(username);
	}

}
