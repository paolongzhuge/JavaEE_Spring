package cn.chs.ioc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {

	public static void main(String[] args) {
		//1，初始化Spring容器，加载配置文件
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2，通过容器获取userDao实例
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		//3，调用实例方法
		userDao.say();

	}

}
