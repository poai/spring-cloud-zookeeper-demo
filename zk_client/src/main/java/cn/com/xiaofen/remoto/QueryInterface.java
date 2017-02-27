package cn.com.xiaofen.remoto;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//定义抽象的远程接口服务
@FeignClient(value = "queryTest", path = "/")
public interface QueryInterface {
	@RequestMapping(value = "/testZk")
	public String query(@PathVariable("id") String id);
}
