package cn.a7e7.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.a7e7.po.Customer;

/**
 * 入门程序测试类
 * 
 * */
public class MybatisTest {

	/**
	 * 根据客户编号查询客户信息
	 * */
	@Test
	public void findCustmoerByIdTest()throws Exception{
		//1.读取配置文件
		String reourceString = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(reourceString);
		//2.根据配置文件构建SqlSessionFatcry
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3.通过sqlsessionFactory创建sessionFactory
		SqlSession sqlSession = sqlsessionFactory.openSession();
		//4.sqlSession执行映射文件中定义的SQL，并返回映射结果
		//第一个参数是sql的id，第二个阐述传入给sql的展位符参数
		Customer customer = sqlSession.selectOne("cn.a7e7.po.Customer.findCustomerById",1);
	
		//打印输出结果
		System.out.println(customer.toString());
		//5,关闭SqlSession
		sqlSession.close();
		
	
	
	
	
	
	
	
	}
}
