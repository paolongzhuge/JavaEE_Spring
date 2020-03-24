package cn.a7e7.jdbc;
//测试类


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

	@Test
	public void xmlTest() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		//调用实例中的转账方法
		accountDao.transfer("Joa","Joy",100.00);
		//输出提示信息
		System.out.println("转账成功");
	}
	
	@Test
	public void annotationTest() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_annoctation.xml");
		//获取AccountDao实例
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		//调用实例中的转账方法
		accountDao.transfer("Joa","Joy",100.00);
		//输出提示信息
		System.out.println("转账成功");
	}

}
