package cn.com.xiaofen.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {
	@RequestMapping("/query/{id}")
	public String query(@PathVariable String id) {
		return "{random:" + Math.random() + ",id:" + id + "}";
	}
}
