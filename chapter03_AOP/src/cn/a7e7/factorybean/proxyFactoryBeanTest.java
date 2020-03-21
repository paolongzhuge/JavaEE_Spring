package cn.a7e7.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.a7e7.jdk.UserDao;


public class proxyFactoryBeanTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String xmlPath = "cn/a7e7/factorybean/applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//从Spring容器获得内容
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");

		//执行方法
		userDao.addUser();
		userDao.deleteUser();
	}
}
