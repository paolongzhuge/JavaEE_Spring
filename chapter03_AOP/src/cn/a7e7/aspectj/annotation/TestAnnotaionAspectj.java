package cn.a7e7.aspectj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.a7e7.jdk.UserDao;

//测试类
public class TestAnnotaionAspectj {

	public static void main(String[] args) {
		String xmlPath = "cn/a7e7/aspectj/annotation/applicationContext.xml";
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		//1 从Spring容器获取内容
		UserDao userDao= (UserDao) applicationContext.getBean("userDao");
		//2 执行方法
		userDao.addUser();
	}

}
