package cn.com.xiaofen;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
// 启用REST 客户端
@EnableFeignClients
// 启用客户端负载均衡
@RibbonClient(name = "my", configuration = RibbonConfig.class)
// 启用服务发现
@EnableDiscoveryClient
// 启用断路器
@EnableHystrix
@ImportResource(value = "spring_mvc.xml")
@ComponentScan("cn.com.xiaofen")
public class ZkClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZkClientApplication.class, args);
	}
	/* Spring JDBC */
	@Bean
	public JdbcTemplate primaryJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	/* TOMCAT DataSourcePool */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
