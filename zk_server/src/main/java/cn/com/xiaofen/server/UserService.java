package cn.com.xiaofen.server;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.xiaofen.Bean;

@RestController
public class UserService {
	// PathVariable
	@RequestMapping("/user/{id}")
	public Bean getUserInfo(@PathVariable("id") String id) {
		Bean bean = new Bean();
		bean.setLikes("Orange");
		bean.setName("lili");
		bean.setId(id);
		return bean;
	}
	// Path
	@RequestMapping
	public Bean getUserList(@RequestParam(required = true, value = "id") String id) {
		Bean bean = new Bean();
		bean.setLikes("Banana");
		bean.setName("Mr Wang");
		bean.setId(id);
		return bean;
	}
}
