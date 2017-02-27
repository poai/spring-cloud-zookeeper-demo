package cn.com.xiaofen.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "itgsTest", path = "/")
public interface QueryInterface {
	@RequestMapping(value = "/query")
	public String query(@PathVariable("id") String id);
}
