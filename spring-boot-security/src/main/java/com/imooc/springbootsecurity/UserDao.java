package com.imooc.springbootsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<UserDo> getUsersByUsername(String username) {
		String sql = "select id, username, password from user where username = ?";
		return jdbcTemplate.query(sql, new String[] { username }, new BeanPropertyRowMapper<>(UserDo.class));
	}

	public List<String> getApisByUsername(String username) {
		String sql = "select path from user left join roleapi on user.roleId=roleapi.roleId left join api on roleapi.apiId=api.id where username='?' ";
		return jdbcTemplate.queryForList(sql, new String[] { username }, String.class);
	}

}
