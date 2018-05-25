package com.fourth.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fourth.bean.UserImportant;

@Repository
public interface UserImportantDAO {
	UserImportant findAllById(@Param("user_id") Long user_id);
	int deleteById(@Param("user_id") Long user_id);
	int deleteBatchById(@Param("array") Long[] idArray);
	int updatePayPasswordById(@Param("user_id") Long userId);
}
