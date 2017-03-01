package cn.com.xiaofen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@ComponentScan("cn.com.xiaofen")
public class ItgsQueryApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItgsQueryApplication.class, args);
	}
}
