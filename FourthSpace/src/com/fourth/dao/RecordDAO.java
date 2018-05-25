package com.fourth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fourth.bean.ShoppingRecord;

@Repository
public interface RecordDAO {
	List<ShoppingRecord> findAll();
	List<ShoppingRecord> findLikeId(@Param("orderId") Long orderId);
	ShoppingRecord findById(@Param("id") Long orderId);
	int updateById(ShoppingRecord record); 
}
