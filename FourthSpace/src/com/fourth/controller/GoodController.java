package com.fourth.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourth.bean.Good;
import com.fourth.service.GoodService;

@Controller
@RequestMapping("/good")
public class GoodController {
	@Autowired
	private GoodService goodService;
	
	@RequestMapping(value="",method=RequestMethod.GET)//��ȡȫ����Ʒ��Ϣ
	@ResponseBody
	public List<Good> findAll(HttpServletResponse response) {		
		List<Good> goods=goodService.findAll();
		return goods;
	}
	
	@RequestMapping(value="/moreInfo",method=RequestMethod.POST)
	@ResponseBody
	public Good moreInfo(@RequestParam String goodName) {
		return goodService.findByName(goodName);
	}
	
	@RequestMapping(value="/changeGood",method=RequestMethod.POST)//���»������Ʒ��Ϣ
	@ResponseBody
	public int changeGood(Good good) {
		if(good.getId()!=null) {
			return goodService.updateGoodByName(good);//����
		}else {
			return goodService.insertGood(good);//���
		}
		
	}
	 
	@RequestMapping("/deleteGood")//������Ʒ����ɾ����Ʒ
	@ResponseBody
	public int deleteGood(@RequestParam String goodName) {
		return goodService.deleteGoodByName(goodName);
	}
	
	@RequestMapping("/deleteBatch")
	@ResponseBody
	public int deleteBatch(@RequestParam String[] myArray) {
		return goodService.deleteBatchByName(myArray);
	}
	@RequestMapping("/query")
	@ResponseBody
	public List<Good> queryGood(@RequestParam String goodName){
		return goodService.findLikeName(goodName);
	}
	
}
