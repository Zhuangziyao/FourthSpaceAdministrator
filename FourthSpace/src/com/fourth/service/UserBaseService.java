package com.fourth.service;

import java.util.List;

import com.fourth.bean.UserBase;

public interface UserBaseService {
	int insertUserBase(UserBase userBase);
	List<UserBase> findAll();
	List<UserBase> findLikeId(Long userId);
	int deleteById(Long userId);
	int deleteBatchById(Long[] idArray);
	int updatePasswordById(Long userId);
}
