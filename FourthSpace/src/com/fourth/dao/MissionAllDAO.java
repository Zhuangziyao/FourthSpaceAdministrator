package com.fourth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fourth.bean.MissionAll;

@Repository
public interface MissionAllDAO {
	List<MissionAll> findAll();
	List<MissionAll> findLikeId(@Param("mission_id") Long missionId);
	int deleteById(@Param("mission_id") Long missionId);
	int updateById(MissionAll missionAll);
	int insertMission(MissionAll missionAll);
	int deleteBatchById(@Param("array") Long[] array);
}
