package com.fourth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.bean.ShoppingRecord;
import com.fourth.dao.RecordDAO;
import com.fourth.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{
	@Autowired
	private RecordDAO recordDAO;
	
	public List<ShoppingRecord> findAll(){
		return recordDAO.findAll();
	}
	
	public List<ShoppingRecord> findLikeId(Long orderId){
		return recordDAO.findLikeId(orderId);
	}
	
	public ShoppingRecord findById(Long orderId) {
		return recordDAO.findById(orderId);
	}
	
	public int updateById(ShoppingRecord record) {
		return recordDAO.updateById(record);
	}
}
