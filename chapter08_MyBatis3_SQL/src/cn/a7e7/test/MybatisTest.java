package cn.a7e7.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.a7e7.po.Customer;
import cn.a7e7.utils.MybatisUtils;

/**
 * 入门程序测试类
 * 
 */
public class MybatisTest {

	/**
	 * 1 根据客户姓名和职业组合查询客户信息列表 <if>
	 */
	@Test
	public void findCustomerByNameAndJobsTest() {
		// 通过工具类生成SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSession();
		// 创建Customer对象，封装需要组合查询的对象的条件
		Customer customer = new Customer();
		customer.setUsername("jack");
		customer.setJobs("teacher");
		// 执行SqlSession的查询方法，返回结果集
		List<Customer> customers = sqlSession.selectList("cn.a7e7.mapper.CustomerMapper.findCustomerByNameAndJobs",
				customer);
		// 输出查询结果信息
		for (Customer customer2 : customers) {
			// 打印输出结果
			System.out.println(customer2);
		}
		// 关闭SqlSession
		sqlSession.close();
	}

	/**
	 * 2 根据客户姓名和职业组合查询客户信息列表 <choose>、<when>、<otherwise>
	 */
	@Test
	public void findCustomerByNameOrJobsTest() {
		// 通过工具类生成SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSession();
		// 创建Customer对象，封装需要组合查询的对象的条件
		Customer customer = new Customer();
		// customer.setUsername("jack");
		customer.setJobs("teacher");
		// 执行SqlSession的查询方法，返回结果集
		List<Customer> customers = sqlSession.selectList("cn.a7e7.mapper.CustomerMapper.findCustomerByNameOrJobs",
				customer);
		// 输出查询结果信息
		for (Customer customer2 : customers) {
			// 打印输出结果
			System.out.println(customer2);
		}
		// 关闭SqlSession
		sqlSession.close();
	}

	/**
	 * 更新客户
	 */
	@Test
	public void updateCustomerTest() {
		// 通过工具类生成SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSession();
		// 创建Customer对象，并向对象中添加数据
		Customer customer = new Customer();
		customer.setId(3);
		customer.setPhone("12345678910");
		// 执行SqlSession的更新方法，返回的是SQL数据影响的行数
		int rows = sqlSession.update("cn.a7e7.mapper.CustomerMapper.updateCustomer", customer);
		// 通过返回结果判断更新操作是否执行成功
		if (rows > 0) {
			System.out.println("您成功修改了" + rows + "条数据");
		} else {
			System.out.println("执行修改操作失败！！！");
		}
		// 提交事务
		sqlSession.commit();
		// 关闭SqlSession
		sqlSession.close();
	}

	/**
	 * 根据客户编号批量查询信息
	 */
	@Test
	public void findCustomerByIdTest() {
		// 通过工具类生成SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSession();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		// 执行SqlSession的查询方法,返回结果集
		List<Customer> customers = sqlSession.selectList("cn.a7e7.mapper.CustomerMapper.findCustomerByIds", ids);
		// 输出查询结果信息
		for (Customer customer : customers) {
			// 打印输出结果
			System.out.println(customer);
		}
		// 关闭SqlSession
		sqlSession.close();
	}
	/**
	 * <bind>元素的使用：根据客户名模糊查询客户信息
	 */
	@Test
	public void findCustomerByNameTest() {
		// 通过工具类生成SqlSession对象
		SqlSession sqlSession = MybatisUtils.getSession();
		//创建Customer对象，封装查询题哦条件
		Customer customer = new Customer();
		customer.setUsername("j");
		//执行SqlSession的查询方法，返回结果集
		List<Customer> customers = sqlSession.selectList("cn.a7e7.mapper.CustomerMapper.findCustomerByName",customer);
		//输出查询结果信息
		for (Customer customer2 : customers) {
			//打印输出结果
			System.out.println(customer2);
		}
		
		// 关闭SqlSession
		sqlSession.close();
	}
}
