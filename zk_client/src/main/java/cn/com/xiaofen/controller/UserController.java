package cn.com.xiaofen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.xiaofen.remote.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;

	@RequestMapping("/user/{id}")
	public String getUserInfo(@PathVariable("id") String id) {
		return us.getUserInfo(id);
	}
	@RequestMapping("/user")
	public String getUSerList(@RequestParam("id") String id) {
		return us.getUSerList(id);
	}
}
