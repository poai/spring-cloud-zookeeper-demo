package cn.com.xiaofen.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping("/test_redirect")
	public String testRedirect() {
		return "redirect:/index.html";
	}
}
