package com.fourth.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourth.bean.ShoppingRecord;
import com.fourth.service.RecordService;

@Controller
@RequestMapping("/order")
public class RecordController {
	@Autowired
	private RecordService recordService;
	
	@RequestMapping("")
	@ResponseBody
	public List<ShoppingRecord> findAll(){
		return recordService.findAll();
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public List<ShoppingRecord> findLikeName(@RequestParam Long orderId){
		return recordService.findLikeId(orderId);
	}
	
	@RequestMapping("/checkBuyBack")
	@ResponseBody
	public ShoppingRecord checkBuBack(@RequestParam Long orderId) {
		return recordService.findById(orderId);
	}
	
	@RequestMapping(value="/updateRecord",method=RequestMethod.POST)
	@ResponseBody
	public int updateRecord(ShoppingRecord record) {
		return recordService.updateById(record);
	}
}
