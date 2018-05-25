package com.fourth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.fourth.bean.UserBase;

@Repository
public interface UserBaseDAO {
	int insertUserBase(UserBase userBase);
	int deleteuserBase(Integer id);
	List<UserBase> findAll();
	List<UserBase> findLikeId(@Param("user_id") Long userId);
	int deleteById(@Param("user_id") Long userId);
	int deleteBatchById(@Param("array") Long[] idArray);
	int updatePasswordById(@Param("user_id") Long userId);
}
