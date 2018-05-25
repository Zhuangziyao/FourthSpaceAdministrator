package com.fourth.bean;

import java.util.Date;

public class UserBase {
	private Long id;
	private String password;
	private String nickname;
	private byte[] avatar;
	private Integer star;
	private Date lastLogin;
	private UserImportant userImportant;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public UserImportant getUserImportant() {
		return userImportant;
	}
	public void setUserImportant(UserImportant userImportant) {
		this.userImportant = userImportant;
	}
}
