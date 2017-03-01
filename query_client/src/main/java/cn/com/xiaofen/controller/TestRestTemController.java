package cn.com.xiaofen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestRestTemController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private EurekaClient eurekaClient;

	@RequestMapping("/query")
	@HystrixCommand(fallbackMethod = "queryLocal")
	public String query(@RequestParam("id") String id) {
		InstanceInfo iInfo = eurekaClient.getNextServerFromEureka("QueryServer", false);
		System.out.println(iInfo.getHostName() + "_" + iInfo.getPort());
		return restTemplate.getForObject(iInfo.getHomePageUrl() + "/query/"+id, String.class);
	}

	public String queryLocal(String id) {
		return "LOCALHOST DATA";
	}
}
