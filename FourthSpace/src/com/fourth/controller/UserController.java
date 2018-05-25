package com.fourth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourth.bean.UserBase;
import com.fourth.service.UserBaseService;
import com.fourth.service.UserImportantService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserBaseService userBaseService;
	@Autowired
	private UserImportantService userImportantService;
	
	@RequestMapping("")
	@ResponseBody
	public List<UserBase> findAll(){
		List<UserBase> userBases=userBaseService.findAll();
		return userBases;
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public List<UserBase> findLikeId(@RequestParam Long userId){
		return userBaseService.findLikeId(userId);
	}
	
	@RequestMapping("/insert")//实验方法，不能用
	public void insertUserBase() {
		UserBase u=new UserBase();
		u.setId(1234567L);
		u.setPassword("123456");
		u.setNickname("text");
		byte[] a=new byte[2];
		a[0]=1;
		u.setAvatar(a);
		int i=userBaseService.insertUserBase(u);
		System.out.println(i);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public int deleteById(@RequestParam Long userId) {
		userImportantService.deleteById(userId);
		return userBaseService.deleteById(userId);
	}
	
	@RequestMapping("/deleteBatch")
	@ResponseBody
	public int deleteBatch(@RequestParam Long[] myArray) {
		userImportantService.deleteBatchById(myArray);
		return userBaseService.deleteBatchById(myArray);
	}
	
	@RequestMapping("/resetPassword")
	@ResponseBody
	public int resetPassword(@RequestParam Long userId) {
		userImportantService.updatePayPasswordById(userId);
		return userBaseService.updatePasswordById(userId);
	}
	
}
