package com.imooc.springbootsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ApiDao apiDao;

	public List<UserDo> getUserByUsername(String username) {
		return userDao.getUsersByUsername(username);
	}

	public List<String> getApisByUsername(String username) {
		return userDao.getApisByUsername(username);
	}

	public List<String> getApiPaths() {
		return apiDao.getApiPaths();
	}
}
