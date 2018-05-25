package com.fourth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fourth.bean.MissionAll;
import com.fourth.dao.MissionAllDAO;
import com.fourth.dao.MissionTodayDAO;
import com.fourth.service.MissionAllService;

@Service
public class MissionAllServiceImpl implements MissionAllService{
	@Autowired
	private MissionAllDAO missionAllDAO;
	@Autowired
	private MissionTodayDAO missionTodayDAO;
	
	public List<MissionAll> findAll(){
		return missionAllDAO.findAll();
	}
	
	public List<MissionAll> findLikeId(Long missionId){
		return missionAllDAO.findLikeId(missionId);
	}
	
	public int deleteById(Long missionId) {
		int a=missionTodayDAO.deleteById(missionId);
		int b=missionAllDAO.deleteById(missionId);
		if(a==b)
			return 1;
		else
			return 0;
	}
	
	public int updateById(MissionAll missionAll) {
		return missionAllDAO.updateById(missionAll);
	}
	
	public int insertMission(MissionAll missionAll) {
		return missionAllDAO.insertMission(missionAll);
	}
	
	public int deleteBatchById(Long[] idArray) {
		return missionAllDAO.deleteBatchById(idArray);
	}
}
