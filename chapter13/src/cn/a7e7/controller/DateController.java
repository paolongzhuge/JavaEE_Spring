package cn.a7e7.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日期控制类
 *
 */
@Controller
public class DateController {

	/**
	 * 使用自定义类型绑定日期数据
	 * @param date
	 * @return
	 */
	@RequestMapping("/customDate")
	public String customDate(Date date) {
		System.out.println("date=" + date);
		return "success";
	}
}
