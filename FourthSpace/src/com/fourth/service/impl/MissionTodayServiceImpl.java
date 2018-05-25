package com.fourth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.dao.MissionTodayDAO;
import com.fourth.service.MissionTodayService;

@Service
public class MissionTodayServiceImpl implements MissionTodayService{
	@Autowired
	private MissionTodayDAO missionTodayDAO;
	
	public int deleteById(Long missionId) {
		return missionTodayDAO.deleteById(missionId);
	}
}
