package cn.a7e7.jdbc;

import java.util.List;

public interface AccountDao {

	//添加
	public int addAccount(Account account);
	//更新
	public int updataAccount(Account account);
	//删除
	public int deleteAccount(int id);
	
	//通过id查询
	public Account findAccountById(int id);
	//查询所有账户
	public List<Account> findAllAccount();
	
	//转账
	public void transfer(String outUser,String inUser,Double money);
}
