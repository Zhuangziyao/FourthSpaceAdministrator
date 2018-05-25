package com.fourth.service;

import java.util.List;

import com.fourth.bean.ShoppingRecord;

public interface RecordService {
	List<ShoppingRecord> findAll();
	List<ShoppingRecord> findLikeId(Long orderId);
	ShoppingRecord findById(Long orderId);
	int updateById(ShoppingRecord record);
}
