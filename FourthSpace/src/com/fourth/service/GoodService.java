package com.fourth.service;

import java.util.List;

import com.fourth.bean.Good;

public interface GoodService {
	List<Good> findAll();
	Good findByName(String name);
	int updateGoodByName(Good good);
	int deleteGoodByName(String goodName);
	int insertGood(Good good);
	List<Good> findLikeName(String goodName);
	int deleteBatchByName(String[] nameArray);
}
