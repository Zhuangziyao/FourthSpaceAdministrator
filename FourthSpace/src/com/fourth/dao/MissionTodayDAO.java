package com.fourth.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface MissionTodayDAO {
	int deleteById(@Param("mission_id") Long missionId);
}
