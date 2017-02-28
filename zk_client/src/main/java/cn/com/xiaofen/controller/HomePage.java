package cn.com.xiaofen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.xiaofen.bean.Bean;

@Controller
public class HomePage {
	@RequestMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		Bean bean = new Bean();
		bean.setLikes("Play Game!!");
		bean.setName("Xiao Fen!!");
		mav.addObject("bean", bean);
		return mav;
	}
}
