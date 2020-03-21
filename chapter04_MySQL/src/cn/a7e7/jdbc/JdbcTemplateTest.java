package cn.a7e7.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

	/**
	 * 使用execute（）方法建表
	 * */
//	public static void main(String[] args) {
//		// 加载配置文件
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//获取JdbcTemplate实例
//		JdbcTemplate jdbcTemplate=  (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//		//使用execute（）方法执行SQL语句，创建账户管理表accout
//		jdbcTemplate.execute("create table account("+
//							"id int primary key auto_increment,"+
//							"username varchar(50),"+
//							"balance double)");
//		System.out.println("账户表account创建成功");
//	}
	/**
	 * 学习junit4测试
	 * */
	@Test
	public void mainTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取JdbcTemplate实例
		JdbcTemplate jdbcTemplate=  (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		//使用execute（）方法执行SQL语句，创建账户管理表accout
		jdbcTemplate.execute("create table account("+
							"id int primary key auto_increment,"+
							"username varchar(50),"+
							"balance double)");
		System.out.println("账户表account创建成功");
	}

}
