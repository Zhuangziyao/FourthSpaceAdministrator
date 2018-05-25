package com.fourth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fourth.bean.Good;

@Repository
public interface GoodDAO {
	List<Good> findAll();
	Good findByName(@Param("good_name") String name);
	int updateGoodByName(Good good);
	int deleteGoodByName(@Param("good_name") String goodName);
	int insertGood(Good good);
	Long findMaxGoodId();
	List<Good> findLikeName(@Param("good_name") String goodName);
	int deleteBatchByName(@Param("array") String[] nameArray);
}
