package cn.a7e7.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.a7e7.aspect.MyAspect;

/**
 * JDK 代理类
 * */
public class JdkProxy implements InvocationHandler {

	//声明目标类接口
	private UserDao userDao;

	//创建代理方法
	public Object createProxy(UserDao userDao) {
		this.userDao = userDao;
		//1.类加载器
		ClassLoader classLoader = JdkProxy.class.getClassLoader();
		//2,被代理对象实现的所有接口
		Class<?>[] clazz = userDao.getClass().getInterfaces();
		//3，使用代理类，进行增强，返回的代理后的对象
		return Proxy.newProxyInstance(classLoader, clazz, this);
	}
	/**
	 * 所有动态代理类的方法调用，都会交由invoke（）方法去处理
	 * proxy
	 * method将要织金县的方法信息（反射）
	 * args执行方法时需要的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//声明切面
		MyAspect mysAspect = new MyAspect();
		//前增强
		mysAspect.chak_Permissions();
		
		//在目标类上调用方法，并传入参数
		Object obj =method.invoke(userDao, args);
		
		//后增强
		mysAspect.log();
		return obj;

	}

}
