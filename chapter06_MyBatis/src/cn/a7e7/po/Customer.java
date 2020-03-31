package cn.a7e7.po;
/**
 * 客户持久化类
 * 
 * */
public class Customer {

	private Integer idInteger;		//主键id
	private String usernameString;	//客户名称
	private String jobString;		//职业
	private String phoneString;		//电话
	
	public Integer getIdInteger() {
		return idInteger;
	}
	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	public String getJobString() {
		return jobString;
	}
	public void setJobString(String jobString) {
		this.jobString = jobString;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	@Override
	public String toString() {
		return "Customer [idInteger=" + idInteger + ", usernameString=" + usernameString + ", jobString=" + jobString
				+ ", phoneString=" + phoneString + "]";
	}
	
	
	
}
