package com.fourth.service;


import org.apache.ibatis.annotations.Param;

import com.fourth.bean.UserImportant;

public interface UserImportantService {
	UserImportant findAllById(Long id);
	int deleteById(@Param("user_id") Long userId);
	int deleteBatchById(@Param("array") Long[] idArray);
	int updatePayPasswordById(Long userId);
}
