package cn.a7e7.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.a7e7.po.Orders;
import cn.a7e7.po.Person;
import cn.a7e7.po.User;
import cn.a7e7.utils.MybatisUtils;

/**
 * Mybatis关联查询映射测试类
 * 
 * @author chenghuasen
 *
 */
public class MybatisAssociatedTest {

	/**
	 * 嵌套查询
	 */
	@Test
	public void findPersonByIdTest() {
		// 1. 通过工具类生产SqlSession对象
		SqlSession session = MybatisUtils.getSession();
		// 2. 使用Mybatis嵌套查询对方式查询id为1的人的信息
		Person person = session.selectOne("cn.a7e7.mapper.PersonMapper.findPersonById", 1);
		// 3. 输出查询结果信息
		System.out.println(person.getName());
		// 4. 关闭SqlSession
		session.close();
	}
	
	/**
	 * 嵌套结果
	 */
	@Test
	public void findPersonById2Test() {
		// 1. 通过工具类生产SqlSession对象
		SqlSession session = MybatisUtils.getSession();
		// 2. 使用Mybatis嵌套查询对方式查询id为1的人的信息
		Person person = session.selectOne("cn.a7e7.mapper.PersonMapper.findPersonById2", 1);
		// 3. 输出查询结果信息
		System.out.println(person);
		// 4. 关闭SqlSession
		session.close();
	}
	/**
	 * 一对多
	 */
	@Test
	public void findUserTest() {
		// 1. 通过工具类生产SqlSession对象
		SqlSession session = MybatisUtils.getSession();
		// 2. 查询id为1的用户信息
		User user = session.selectOne("cn.a7e7.mapper.UserMapper.findUserWithOrders", 1);
		// 3. 输出查询结果信息
		System.out.println(user);
		// 4. 关闭SqlSession
		session.close();
	}
	
	/**
	 * 多对多
	 */
	@Test
	public void findOrdersTest() {
		// 1. 通过工具类生产SqlSession对象
		SqlSession session = MybatisUtils.getSession();
		// 2. 查询订单中的商品信息
		Orders orders = session.selectOne("cn.a7e7.mapper.OrdersMapper.findOrderWithProduct", 1);
		// 3. 输出查询结果信息
		System.out.println(orders);
		// 4. 关闭SqlSession
		session.close();
	}
	/**
	 * 多对多嵌套结果
	 */
	@Test
	public void findOrders2Test() {
		// 1. 通过工具类生产SqlSession对象
		SqlSession session = MybatisUtils.getSession();
		// 2. 查询订单中的商品信息
		Orders orders = session.selectOne("cn.a7e7.mapper.OrdersMapper.findOrderWithProduct2", 1);
		// 3. 输出查询结果信息
		System.out.println(orders);
		// 4. 关闭SqlSession
		session.close();
	}
}
