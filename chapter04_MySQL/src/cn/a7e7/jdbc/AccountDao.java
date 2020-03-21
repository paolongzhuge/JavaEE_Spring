package cn.a7e7.jdbc;

public interface AccountDao {

	//添加
	public int addAccount(Account account);
	//更新
	public int updataAccount(Account account);
	//删除
	public int deleteAccount(int id);
}
