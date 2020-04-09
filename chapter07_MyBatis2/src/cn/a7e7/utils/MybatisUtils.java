package cn.a7e7.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

	//@SuppressWarnings("unused")
	private static SqlSessionFactory sqlsessionFactory = null;
	//初始化SqlSessionFactor对象
	static{
		try {
			//使用Mybatis提供的Resources类加载Mybatis的配置文件
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//构建sqlSessionFactory工厂
			sqlsessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	//获取SqlSession对象的静态方法
	public static SqlSession getSession() {
		return sqlsessionFactory.openSession();
		
	}
	
}
