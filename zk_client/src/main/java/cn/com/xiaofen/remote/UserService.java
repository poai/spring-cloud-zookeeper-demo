package cn.com.xiaofen.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("USERSERVER")
public interface UserService {
	@RequestMapping("/user/{id}")
	public String getUserInfo(@PathVariable("id") String id);
	@RequestMapping("/user")
	public String getUSerList(@RequestParam("id") String id);
}
