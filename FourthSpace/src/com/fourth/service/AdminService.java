package com.fourth.service;

import com.fourth.bean.Admin;

public interface AdminService {
	String findByIdAndPwd(String id,String password);
	Admin getInfoById(String adminId);
	int updateById(Admin admin);
}
