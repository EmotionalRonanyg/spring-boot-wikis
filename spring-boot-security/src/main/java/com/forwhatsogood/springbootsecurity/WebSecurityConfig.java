package com.forwhatsogood.springbootsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 配置类
@EnableWebSecurity // 启动安全机制
public class WebSecurityConfig {

	@Autowired
	private UserService userService;

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			List<UserDo> users = userService.getUserByUsername(username);
			if (users == null || users.size() == 0) {
				throw new UsernameNotFoundException("用户名未找到");
			}
			String password = users.get(0).getPassword();
			PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			String passwordAfterEncoder = passwordEncoder.encode(password);
			System.out.println(username + "/" + passwordAfterEncoder);

			List<String> roles = userService.getRoleByUsername(username);
			List<String> permissions = userService.getPermissionsByUsername(username);

			String[] permissionArr = new String[roles.size() + permissions.size()];
			int permissionArrIndex = 0;
			for (String role : roles) {
				permissionArr[permissionArrIndex] = "ROLE_" + role;
				permissionArrIndex++;
			}
			for (String permission : permissions) {
				permissionArr[permissionArrIndex] = permission;
				permissionArrIndex++;
			}
			return User.withUsername(username).password(passwordAfterEncoder).authorities(permissionArr).build();
		};

	}
	
	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
	    return new WebSecurityConfigurerAdapter() {
	        @Override
	        public void configure(HttpSecurity httpSecurity) throws Exception {
	            httpSecurity.
	                    authorizeRequests().antMatchers("/guest/**").permitAll().
	                    and().authorizeRequests().antMatchers("/admin/**").hasRole("admin").
	                    and().authorizeRequests().antMatchers("/authenticated/**").authenticated().
	                    and().authorizeRequests().antMatchers("/permission1/**").hasAuthority("permission1").
	                    and().authorizeRequests().antMatchers("/permission2/**").hasAuthority("permission2").
	                    and().authorizeRequests().antMatchers("/permission3/**").hasAuthority("permission3").
	                    and().authorizeRequests().antMatchers("/permission4/**").hasAuthority("permission4").
	                    and().formLogin().
	                    and().authorizeRequests().anyRequest().permitAll();
	        }
	    };
	}


}
