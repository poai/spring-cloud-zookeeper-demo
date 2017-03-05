package cn.com.xiaofen.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.xiaofen.bean.Byonet;

@Controller
public class ByonetController {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	
	@RequestMapping("/byonetListFreeMaker")
	public String byonetListFreeMaker(Map<String,Object> model) {
		String sql = "select kkid,kkmc,x,y from t_itgs_tgsinfo";
		BeanPropertyRowMapper<Byonet> rowMapper = new BeanPropertyRowMapper<Byonet>(Byonet.class);
		List<Byonet> byonets=jdbcTemplate.query(sql, rowMapper);
		model.put("byonets", byonets);
		return "byonetList";
	}

}
