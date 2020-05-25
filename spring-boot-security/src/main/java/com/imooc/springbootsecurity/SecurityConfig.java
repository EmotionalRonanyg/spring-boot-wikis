package com.imooc.springbootsecurity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity // 启用安全管理
public class SecurityConfig {
	@Autowired
	private SecurityService securityService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
		return new WebSecurityConfigurerAdapter() {
			@Override
			public void configure(HttpSecurity httpSecurity) throws Exception {
				// 从数据库中获取权限列表
				List<String> paths = securityService.getApiPaths();
				for (String path : paths) {
					// 对/xxx/**路径的访问，需要具备xxx权限
					// 例如访问/addGoods，需要具备addGoods权限
					httpSecurity.authorizeRequests().antMatchers("/" + path + "/**").hasAuthority(path);
				}
				// 未登录时自动跳转/notLogin
				httpSecurity.authorizeRequests().and().formLogin().loginPage("/notLogin")
						// 登录处理路径、用户名、密码
						.loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
						.permitAll()
						// 登录成功处理
						.successHandler(new AuthenticationSuccessHandler() {
							@Override
							public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
									HttpServletResponse httpServletResponse, Authentication authentication)
									throws IOException, ServletException {
								httpServletResponse.setContentType("application/json;charset=utf-8");
								ResultBo result = new ResultBo<>();
								ObjectMapper mapper = new ObjectMapper();
								PrintWriter out = httpServletResponse.getWriter();
								out.write(mapper.writeValueAsString(result));
								out.close();
							}
						})
						// 登录失败处理
						.failureHandler(new AuthenticationFailureHandler() {
							@Override
							public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
									HttpServletResponse httpServletResponse, AuthenticationException e)
									throws IOException, ServletException {
								httpServletResponse.setContentType("application/json;charset=utf-8");
								ResultBo result = new ResultBo<>(new Exception("登录失败"));
								ObjectMapper mapper = new ObjectMapper();
								PrintWriter out = httpServletResponse.getWriter();
								out.write(mapper.writeValueAsString(result));
								out.flush();
								out.close();
							}
						});
				// 禁用csrf(跨站请求伪造)
				httpSecurity.authorizeRequests().and().csrf().disable();
			}
		};
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			List<UserDo> users = securityService.getUserByUsername(username);
			if (users == null || users.size() == 0) {
				throw new UsernameNotFoundException("用户名错误");
			}
			String password = users.get(0).getPassword();
			List<String> apis = securityService.getApisByUsername(username);
			// 将用户名username、密码password、对应权限列表apis放入组件
			return User.withUsername(username).password(password).authorities(apis.toArray(new String[apis.size()]))
					.build();
		};
	}

	public static void main(String[] args) {
		// 输出 $2a$10$kLQpA8S1z0KdgR3Cr6jJJ.R.QsIT7nrCdAfsF4Of84ZBX2lvgtbE.
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
