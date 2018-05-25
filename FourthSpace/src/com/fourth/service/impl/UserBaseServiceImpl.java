package com.fourth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fourth.bean.UserBase;
import com.fourth.bean.UserImportant;
import com.fourth.dao.UserBaseDAO;
import com.fourth.service.UserBaseService;
import com.fourth.util.DataHandler;
@Service
public class UserBaseServiceImpl implements UserBaseService{
	
	@Autowired
	private UserBaseDAO userBaseDAO;
	@Autowired
	private DataHandler dataHandler;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int insertUserBase(UserBase userBase) {
		return userBaseDAO.insertUserBase(userBase);
	}
	
	public List<UserBase> findAll(){
		List<UserBase> userBases=userBaseDAO.findAll();
		for(UserBase userBase:userBases) {
			String password=userBase.getPassword();
			userBase.setPassword(dataHandler.encrypt(password));
			UserImportant userImportant=userBase.getUserImportant();
			String payPassowrd=userImportant.getPayPassword();
			userImportant.setPayPassword(dataHandler.encrypt(payPassowrd));
			userBase.setUserImportant(userImportant);
		}
		return userBases;
	}
	
	public List<UserBase> findLikeId(Long userId){
		List<UserBase> userBases=userBaseDAO.findAll();
		for(UserBase userBase:userBases) {
			String password=userBase.getPassword();
			userBase.setPassword(dataHandler.encrypt(password));
			UserImportant userImportant=userBase.getUserImportant();
			String payPassowrd=userImportant.getPayPassword();
			userImportant.setPayPassword(dataHandler.encrypt(payPassowrd));
			userBase.setUserImportant(userImportant);
		}
		return userBases;
	}
	
	public int deleteById(Long userId) {
		return userBaseDAO.deleteById(userId);
	}
	
	public int deleteBatchById(Long[] idArray) {
		return userBaseDAO.deleteBatchById(idArray);
	}
	
	public int updatePasswordById(Long userId) {
		return userBaseDAO.updatePasswordById(userId);
	}
}
