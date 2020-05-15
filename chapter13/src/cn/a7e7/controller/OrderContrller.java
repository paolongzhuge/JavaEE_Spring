package cn.a7e7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.a7e7.po.Orders;
import cn.a7e7.po.User;

@Controller
public class OrderContrller {

	/**
	 * 向订单查询页面跳转
	 */
	@RequestMapping("/tofindOrdersWithUser")
	public String tofindOrdersWithUser() {
		return "orders";
	}

	@RequestMapping("/findOrdersWithUser")
	public String findOrdersWithUser(Orders orders) {
		Integer ordersId = orders.getOrdersId();
		User user = orders.getUser();
		String username = user.getUsername();
		System.out.println("ordersId=" + ordersId);
		System.out.println("username=" + username);
		return "success";
	}
}
