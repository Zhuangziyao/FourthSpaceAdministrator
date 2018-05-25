package com.fourth.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fourth.bean.Admin;
@Repository
public interface AdminDAO {
	String findByIdAndPwd(@Param("admin_id") String id,@Param("admin_pwd") String password);
	Admin getInfoById(@Param("admin_id") String adminId);
	int updateById(Admin admin);
}
