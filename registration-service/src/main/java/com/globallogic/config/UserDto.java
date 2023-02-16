package com.globallogic.config;



public class UserDto
{
    private String emailId;
    private String password;
    private String userRole;
	public UserDto() {
		super();
		this.emailId = emailId;
		this.password = password;
		this.userRole = userRole;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
	