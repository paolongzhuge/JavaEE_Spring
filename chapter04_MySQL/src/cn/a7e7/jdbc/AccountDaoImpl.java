package cn.a7e7.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {

	// 生命JdbcTemplate属性及其setter方法
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 添加账户
	@Override
	public int addAccount(Account account) {
		// 定义SQL
		String sql = "insert into account(username,balance) value(?,?) ";
		// 定义数组来存放SQL语句中的参数
		Object[] obj = new Object[] { account.getUsername(), account.getBalance()};
		// 执行添加操作，返回的是受SQL语句影响的条数
		int mum = this.jdbcTemplate.update(sql, obj);
		return mum;
	}

	// 更新账户
	@Override
	public int updataAccount(Account account) {
		// 定义SQL语句
		String sql = "update account set username=? , balance=? where id=?";
		// 定义数组来存放SQL语句中的参数
		Object[] params = new Object[] { account.getUsername(), account.getBalance(), account.getId()};
		// 执行更新操作，返回的是受SQL语句影响的条数
		int mum = this.jdbcTemplate.update(sql, params);
		return mum;
	}

	// 删除账户
	@Override
	public int deleteAccount(int id) {
		//定义SQL语句
		String sql = "delete from account where id=?";
		//执行删除操作，返回的是受SQL语句影响的条数
		int num = this.jdbcTemplate.update(sql,id);
		return num;
	}

}
