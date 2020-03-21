package cn.a7e7.jdk;

import org.springframework.stereotype.Repository;

//目标类
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void addUser() {
		System.out.println("添加用户");

	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户");

	}

}
