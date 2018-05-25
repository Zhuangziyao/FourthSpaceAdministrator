package com.fourth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.bean.Admin;
import com.fourth.dao.AdminDAO;
import com.fourth.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;
	
	public String findByIdAndPwd(String id,String password) {
		return adminDAO.findByIdAndPwd(id, password);
	}
	
	public Admin getInfoById(String adminId) {
		return adminDAO.getInfoById(adminId);
	}
	
	public int updateById(Admin admin) {
		return adminDAO.updateById(admin);
	}
}
