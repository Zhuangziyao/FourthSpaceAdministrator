package com.fourth.service;

import java.util.List;

import com.fourth.bean.MissionAll;

public interface MissionAllService {
	List<MissionAll> findAll();
	List<MissionAll> findLikeId(Long missionId);
	int deleteById(Long missionId);
	int updateById(MissionAll missionAll);
	int insertMission(MissionAll missionAll);
	int deleteBatchById(Long[] idArray);
}
