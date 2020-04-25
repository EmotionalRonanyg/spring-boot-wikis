package com.forwhatsogood.springbootsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<UserDo> getUserByUsername(String username){
		String sql="select id,username,password from user where username=?";
		return jdbcTemplate.query(sql,new String[] {username},new BeanPropertyRowMapper<>(UserDo.class));
	}
	
	public List<String> getPermissionsByUsername(String username) {
	    String sql =
	            "select d.permission " +
	            "from user a " +
	            "       join user_r_role b on a.id = b.userid " +
	            "       join role_r_permission c on b.roleid = c.roleid " +
	            "       join permission d on c.permissionid = d.id " +
	            "where a.username = ? " +
	            "union " +
	            "select c.permission " +
	            "from user a " +
	            "       join user_r_permission b on a.id = b.userid " +
	            "       join permission c on b.permissionid = c.id " +
	            "where a.username = ?";
	    return jdbcTemplate.queryForList(sql, new String[]{username, username}, String.class);
	}

	public List<String> getRoleByUsername(String username) {
	    String sql =
	            "select c.role " +
	            "from user a " +
	            "       join user_r_role b on a.id = b.userid " +
	            "       join role c on b.roleid = c.id " +
	            "where a.username = ?";
	    return jdbcTemplate.queryForList(sql, new String[]{username}, String.class);
	}

}
