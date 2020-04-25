package com.imooc.springbootprofile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 微信公众号参数
 */
@Component // 注册为组件
@PropertySource(value = "classpath:wxmp.properties", encoding = "utf-8") // 指定配置文件及编码
public class WxMpParam {
	@Value("${wxmp.appid}")
	private String appid;
	@Value("${wxmp.secret}")
	private String secret;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
