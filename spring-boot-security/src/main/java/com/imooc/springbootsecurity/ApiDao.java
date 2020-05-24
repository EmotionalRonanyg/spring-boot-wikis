package com.imooc.springbootsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ApiDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 获取所有api
	 */
	public List<String> getApiPaths() {
		String sql = "select path from api";
		return jdbcTemplate.queryForList(sql, String.class);
	}
}
