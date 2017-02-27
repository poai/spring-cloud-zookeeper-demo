package cn.com.xiaofen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.com.xiaofen.remoto.QueryInterface;

@SpringBootApplication
// 启用REST 客户端
@EnableFeignClients
@RestController
// 启用客户端负载均衡
@RibbonClient(name = "my", configuration = RibbonConfig.class)
// 启用服务发现
@EnableDiscoveryClient
// 启用断路器
@EnableHystrix
public class ZkClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZkClientApplication.class, args);
	}

	// 远程服务接口,
	@Autowired
	private QueryInterface qi;

	@RequestMapping("/testZk")
	//断路器规则
	//调用远程服务
	@HystrixCommand(commandKey = "", fallbackMethod = "defaultError", groupKey = "")
	public String testZk(String id) {
		return qi.query(id);
	}
	public String defaultError(String id) {
		return "{error,id:" + id + "}";
	}
}
