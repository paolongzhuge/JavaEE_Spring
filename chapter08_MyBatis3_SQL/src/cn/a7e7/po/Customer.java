package cn.a7e7.po;
/**
 * 客户持久化类
 * 
 * */
public class Customer {
	/**
	 * 这里的变量命要和数据库里面的字段名一一对应相同，否则可能会存在出错可能
	 */
	private Integer id;			//主键id
	private String username;	//客户名称
	private String jobs;		//职业
	private String phone;		//电话
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", jobs=" + jobs + ", phone=" + phone + "]";
	}
	
}
