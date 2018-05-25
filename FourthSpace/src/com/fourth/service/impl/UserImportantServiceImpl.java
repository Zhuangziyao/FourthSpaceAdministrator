package com.fourth.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.bean.UserImportant;
import com.fourth.dao.UserImportantDAO;
import com.fourth.service.UserImportantService;

@Service
public class UserImportantServiceImpl implements UserImportantService{
	@Autowired
	private UserImportantDAO userImportantDAO;
	
	public UserImportant findAllById(Long id){
		return userImportantDAO.findAllById(id);
	}
	
	public int deleteById(Long userId) {
		return userImportantDAO.deleteById(userId);
	}
	
	public int deleteBatchById(Long[] idArray) {
		return userImportantDAO.deleteBatchById(idArray);
	}
	
	public int updatePayPasswordById(Long userId) {
		return userImportantDAO.updatePayPasswordById(userId);
	}
}
