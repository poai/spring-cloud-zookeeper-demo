package cn.com.xiaofen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.com.xiaofen.remote.QueryInterface;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@RibbonClient(name = "app", configuration = RibbonConfig.class)
public class ClientApplication {
	/**
	 * 消费服务:
	 * 
	 * .使用 @EnableDiscoveryClient||@EnableDiscoveryClient +EurekaClient 接口
	 * 
	 * .使用DiscoveryClient 简化操作
	 * 
	 * .Ribbon 客户端负载均衡 -->@RibbonClient 注解配置 -->可与 Eureka分离
	 * 
	 * .Feign Rest Client -->@EnableFeignClients
	 * 
	 */

	/*
	 * 总结:
	 * 
	 * 负载均衡:只能负载一次
	 * 
	 * .eurekaClient.getNextServerFromEureka("itgsTest",false);
	 * 
	 * .不需要在使用 @LoadBalanced
	 * 
	 * 
	 * 
	 * 
	 */
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	LoadBalancerClient loadBalancerClient;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@RequestMapping("/query")
	@HystrixCommand(fallbackMethod = "error")
	public String query(String id) {
		InstanceInfo ii = eurekaClient.getNextServerFromEureka("itgsTest", false);
		System.out.println(ii.getHostName() + "_" + ii.getPort());
		return restTemplate.getForObject(ii.getHomePageUrl() + "/query", String.class, id);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private QueryInterface qi;
	@RequestMapping("/query_1")
	public String query_1() {
		return qi.query("you");
	}
	// 出错了
	public String error(String id) {
		return "出错了:id=" + id;
	}
}
