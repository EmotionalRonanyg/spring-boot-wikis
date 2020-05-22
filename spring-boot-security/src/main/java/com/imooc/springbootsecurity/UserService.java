package com.imooc.springbootsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品服务类
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<UserDo> getUserByUsername(String username) {
		return userDao.getUsersByUsername(username);
	}
}
