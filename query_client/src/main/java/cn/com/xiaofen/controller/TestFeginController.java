package cn.com.xiaofen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.com.xiaofen.remote.QueryInterface;

@RestController
public class TestFeginController {
	@Autowired
	QueryInterface service;

	@RequestMapping("/query/{id}")
	// 配置断路器,Service请求异常时调用本地操作
	@HystrixCommand(fallbackMethod = "queryLocal")
	public String query(@PathVariable("id") String id) {
		return service.query(id);
	}

	public String queryLocal(String id) {
		return "LOCALHOST DATA";
	}
}
