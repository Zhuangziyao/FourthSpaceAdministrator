package com.fourth.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.bean.Good;
import com.fourth.dao.GoodDAO;
import com.fourth.service.GoodService;
@Service
public class GoodServiceImpl implements GoodService{
	@Autowired
	private GoodDAO goodDAO;
	
	public List<Good> findAll(){
		return goodDAO.findAll();
	}
	
	public Good findByName(String name) {
		return goodDAO.findByName(name);
	}
	
	public int updateGoodByName(Good good) {
		return goodDAO.updateGoodByName(good);
	}
	
	public int deleteGoodByName(String goodName) {
		return goodDAO.deleteGoodByName(goodName);
	}
	
	public int insertGood(Good good) {
		Long goodId=goodDAO.findMaxGoodId();
		good.setId(goodId+1l);
		good.setGroundDate(new Date());
		return goodDAO.insertGood(good);
	}
	
	public List<Good> findLikeName(String goodName){
		return goodDAO.findLikeName(goodName);
	}
	
	public int deleteBatchByName(String[] nameArray) {
		return goodDAO.deleteBatchByName(nameArray);
	}
}
