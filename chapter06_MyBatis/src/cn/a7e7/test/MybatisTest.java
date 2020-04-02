package cn.a7e7.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.a7e7.po.Customer;

/**
 * 入门程序测试类
 * 
 */
public class MybatisTest {

	/**
	 * 根据客户编号查询客户信息
	 */
	@Test
	public void findCustmoerByIdTest() throws Exception {
		// 1.读取配置文件
		String reourceString = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(reourceString);
		// 2.根据配置文件构建SqlSessionFatcry
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过sqlsessionFactory创建sessionFactory
		SqlSession sqlSession = sqlsessionFactory.openSession();
		// 4.sqlSession执行映射文件中定义的SQL，并返回映射结果
		// 第一个参数是sql的id，第二个阐述传入给sql的占位符参数
		Customer customer = sqlSession.selectOne("cn.a7e7.po.Customer.findCustomerById", 1);

		// 打印输出结果
		System.out.println(customer.toString());
		// 5.关闭SqlSession
		sqlSession.close();
	}

	/**
	 * 根据用户名称模糊查询用户列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void findCutomerByNameTest() throws Exception {
		// 1.读取配置文件
		String reourceString = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(reourceString);
		// 2.根据配置文件构建SqlSessionFatcry
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过sqlsessionFactory创建sessionFactory
		SqlSession sqlSession = sqlsessionFactory.openSession();
		// 4.sqlSession执行映射文件中定义的SQL，并返回映射结果
		List<Customer> customers = sqlSession.selectList("cn.a7e7.po.Customer.findCustomerByName", "j");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		// 5.关闭SqlSession
		sqlSession.close();
	}

	/**
	 * 添加客户
	 * 
	 * @throws Exception
	 */
	@Test
	public void addCustomerTest() throws Exception {
		// 1.读取配置文件
		String reourceString = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(reourceString);
		// 2.根据配置文件构建SqlSessionFatcry
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过sqlsessionFactory创建sessionFactory
		SqlSession sqlSession = sqlsessionFactory.openSession();
		// 4.sqlSession执行添加操作
		// 4.1创建Customer对象，并向对象中添加数据
		Customer customer = new Customer();
		customer.setUsername("aaa");
		customer.setJobs("student1");
		customer.setPhone("13361111111");
		// 4.2执行SqlSession的添加方法，返回的是Sql语句影响的行数
		// 第一个参数是sql的id，第二个阐述传入给sql的占位符参数
		int rows = sqlSession.insert("cn.a7e7.po.Customer.addCustomer", customer);
		//4.3通过返回结果判断插入操作是否成功
		if (rows>0) {
			System.out.println("您成功插入了" + rows + "条数据！");
			}else {
				System.out.println("执行插入操作失败！！");
			}
		//4.4提交事务——增删改都涉及到事务，需要提交事务
		//如果不提交事务，虽然会输出插入成功的提示，但是实际上并不会插入成功。
		sqlSession.commit();
		
		// 5.关闭SqlSession
		sqlSession.close();
	}
	
	/**
	 * 更新客户
	 * @throws Exception
	 */
	@Test
	public void updateCustomerTest() throws Exception {
		// 1.读取配置文件
		String reourceString = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(reourceString);
		// 2.根据配置文件构建SqlSessionFatcry
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过sqlsessionFactory创建sessionFactory
		SqlSession sqlSession = sqlsessionFactory.openSession();
		// 4.sqlSession执行修改操作
		// 4.1创建Customer对象，并向对象中添加数据
		Customer customer = new Customer();
		customer.setId(7);
		customer.setUsername("rose");
		customer.setJobs("programmer");
		customer.setPhone("13300000006");
		// 4.2执行SqlSession的更新方法，返回的是Sql语句影响的行数
		// 第一个参数是sql的id，第二个阐述传入给sql的占位符参数
		int rows = sqlSession.update("cn.a7e7.po.Customer.updateCustomer", customer);
		//4.3通过返回结果判断更新操作是否成功
		if (rows>0) {
			System.out.println("您成功修改了" + rows + "条数据！");
			}else {
				System.out.println("执行修改操作失败！！");
			}
		//4.4提交事务——增删改都涉及到事务，需要提交事务
		//如果不提交事务，虽然会输出插入成功的提示，但是实际上并不会插入成功。
		sqlSession.commit();
		
		// 5.关闭SqlSession
		sqlSession.close();
	}
	/**
	 * 删除客户
	 * @throws Exception
	 */
	@Test
	public void deleteCustomerTest() throws Exception {
		// 1.读取配置文件
		String reourceString = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(reourceString);
		// 2.根据配置文件构建SqlSessionFatcry
		SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3.通过sqlsessionFactory创建sessionFactory
		SqlSession sqlSession = sqlsessionFactory.openSession();
		// 4.sqlSession执行删除操作
		// 4.2执行SqlSession的删除方法，返回的是Sql语句影响的行数
		// 第一个参数是sql的id，第二个阐述传入给sql的占位符参数
		int rows = sqlSession.update("cn.a7e7.po.Customer.deleteCustomer", 7);
		//4.3通过返回结果判断更新操作是否成功
		if (rows>0) {
			System.out.println("您成功删除了" + rows + "条数据！");
			}else {
				System.out.println("执行删除操作失败！！");
			}
		//4.4提交事务——增删改都涉及到事务，需要提交事务
		sqlSession.commit();
		
		// 5.关闭SqlSession
		sqlSession.close();
	}
}
