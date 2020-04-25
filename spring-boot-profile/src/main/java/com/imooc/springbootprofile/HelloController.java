package com.imooc.springbootprofile;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private WxMpParam wxMpParam;

	@GetMapping("/hello")
	public Map hello() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", wxMpParam.getAppid());
		map.put("secret", wxMpParam.getSecret());
		return map;
	}



}
