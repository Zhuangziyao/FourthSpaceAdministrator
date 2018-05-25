package com.fourth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourth.bean.MissionAll;
import com.fourth.service.MissionAllService;

@Controller
@RequestMapping("/mission")
public class MissionController {
	@Autowired
	private MissionAllService missionAllService;
	
	
	@RequestMapping("")
	@ResponseBody
	public List<MissionAll> findAll() {
		return missionAllService.findAll();
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public List<MissionAll> findLikeId(@RequestParam Long missionId){
		return missionAllService.findLikeId(missionId);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public int deleteById(@RequestParam Long missionId) {
		return missionAllService.deleteById(missionId);
	}
	
	@RequestMapping(value="/changeMission",method=RequestMethod.POST)
	@ResponseBody
	public int changeMission(MissionAll missionAll) {
		if(missionAll.getId()!=null)
			return missionAllService.updateById(missionAll);//ÐÞ¸Ä
		else
			return missionAllService.insertMission(missionAll);//Ìí¼Ó
	}
	
	@RequestMapping("/deleteBatch")
	@ResponseBody
	public int deleteBatch(@RequestParam Long[] myArray) {
		return missionAllService.deleteBatchById(myArray);
	}
}
