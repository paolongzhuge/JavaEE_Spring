package cn.a7e7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.a7e7.po.User;

@Controller
public class UserController {

	@RequestMapping("/testJson")
	@ResponseBody
	public User testJson(@RequestBody User user) {
		//打印接收的JSON格式数据
		System.out.println(user);
		//返回JSON格式的响应
		return user;
	}
	
	/**
	 * 接收RESTfulfeng风格的请求，其接收方式为GET
	 */
	@RequestMapping(value = "/user/{id}" , method =RequestMethod.GET )
	@ResponseBody
	public User selectUser(@PathVariable("id") String id) {
		//查看数据接收
		System.out.println("id="+id);
		User user = new User();
		//模拟根据id查询出用户对象数据
		if (id.equals("1234")) {
			user.setUsername("tom");
		}
		return user;
		
	}
}
