package cn.com.xiaofen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//服务注册到ZK
@EnableDiscoveryClient
public class ZkServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZkServerApplication.class, args);
	}
}
