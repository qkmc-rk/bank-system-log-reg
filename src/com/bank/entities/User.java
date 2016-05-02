package com.bank.entities;

public class User {
	private String userId;						/*eg:  20140161*/
	private String personId;				/*eg:510623199407216912*/
	private String userName;				/*eg:阮坤*/
	private String  userPwd;				/*eg:ruankun521*/
	private String oldPwd;					/*eg:ruankun520~*/
	private String phone;					/*eg:18227590043*/
	private String addr;						/*eg：四川农业大学*/
	private int userType;			/*0-系统管理员 1--银行职员 2--普通用户*/
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	/*constructors
	 * */
	public User(String  userId, String personId, String userName, String userPwd,
			String oldPwd, String phone, String addr) {
		this.userId = userId;
		this.personId = personId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.oldPwd = oldPwd;
		this.phone = phone;
		this.addr = addr;
	}
	public User() {
	}
	
	/*getter and setter
	 * */
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
