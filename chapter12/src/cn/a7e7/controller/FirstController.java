package cn.a7e7.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * 控制类
 */
@Controller
//@RequestMapping(value = "/hello")
@RequestMapping("/hello")
public class FirstController {

	@RequestMapping("/firstController")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		// 向模型对象中添加数据
		model.addAttribute("msg", "这是我的第一个Spring MVC程序");
		// 返回逻辑对象
		return "first";
	}

}
