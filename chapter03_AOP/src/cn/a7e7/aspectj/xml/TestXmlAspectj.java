package cn.a7e7.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.a7e7.jdk.UserDao;

public class TestXmlAspectj {

	public static void main(String[] args) {
		String xmlPath = "cn/a7e7/aspectj/xml/applicationContext.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath); 
		//1从Spring容器中获得内容
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		//2执行方法
		userDao.addUser();
	}

}

