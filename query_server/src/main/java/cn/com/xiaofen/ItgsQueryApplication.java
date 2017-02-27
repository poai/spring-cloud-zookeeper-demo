package cn.com.xiaofen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ItgsQueryApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItgsQueryApplication.class, args);
	}
	@RequestMapping(value = "/query")
	public String query(String id) {
		System.out.println("recived:" + id);
		return "{name:xiaofen,age:100}";
	}
	@RequestMapping("/info")
	public String homePage(){
		return "welcome!";
	}
}
