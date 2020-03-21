package cn.a7e7.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.instrument.classloading.tomcat.TomcatLoadTimeWeaver;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

	/**
	 * 使用execute（）方法建表
	 */
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
	 */
	@Test
	public void mainTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取JdbcTemplate实例
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		// 使用execute（）方法执行SQL语句，创建账户管理表accout
		jdbcTemplate.execute("create table account(" + "id int primary key auto_increment," + "username varchar(50),"
				+ "balance double)");
		System.out.println("账户表account创建成功");
	}

	@Test
	public void addAccountTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		// 创建Account对象，并向Account对象中添加数据
		Account account = new Account();
		account.setUsername("tom");
		account.setBalance(1000.00);
		// 执行addAccount()方法，并获取返回结果
		int num = accountDao.addAccount(account);
		if (num >= 0) {
			System.out.println("成功插入了" + num + "条数据！");
		} else {
			System.out.println("插入操作失败！");
		}
	}

	@Test
	public void finAccountById() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		// 创建Account对象，并向Account对象中添加数据
		Account account = new Account();
		account.setId(1);
		account.setUsername("Tom");
		account.setBalance(2000.00);
		// 执行updataAccount（）方法并获取返回结果
		int num = accountDao.updataAccount(account);
		if (num >= 0) {
			System.out.println("成功修改了" + num + "条数据！");
		} else {
			System.out.println("修改操作失败！");
		}
	}

	@Test
	public void deleteAccountTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		// 创建Account对象，并向Account对象中添加数据
		int num = accountDao.deleteAccount(1);
		if (num >= 0) {
			System.out.println("成功删除了" + num + "条数据！");
		} else {
			System.out.println("删除操作失败！");
		}
	}

	@Test
	public void findAccountTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		//执行findAccount（）方法；
		Account account =accountDao.findAccountById(2);
		System.out.println(account);
	}
	

	@Test
	public void findAllAccountTest() {
		// 加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		List<Account> accounts = accountDao.findAllAccount();
		//循环输出集合中的对象
		for (Account act : accounts) {
			System.out.println(act);
		}
	}

}
