package com.fourth.controller;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fourth.bean.Admin;
import com.fourth.service.AdminService;
import com.fourth.util.FileHandler;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private FileHandler fileHandler;
	
	@RequestMapping(value="",method=RequestMethod.GET)//转到登录界面
	public String adminLogin(HttpServletRequest request,@RequestParam(value="locale",defaultValue="zh_CN") String locale) {
		//Java国际化
		if(locale.equals("zh_CN")) {
			Locale lc = new Locale("zh", "CN"); 
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,lc); 
		}else if(locale.equals("en_US")) {
			Locale lc = new Locale("en", "US"); 
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,lc);
		}else {
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
		}
		return "adminLogin";
	}
	
	@RequestMapping("/login")//形参名称必须与form表单中的提交name相同
	@ResponseBody
	public String login(String id,String password,HttpServletRequest request,HttpServletResponse response) {
		//创建cookie保存登录记录
		Cookie cookieId=new Cookie("adminId",id);
		cookieId.setMaxAge(60*60*24);
		cookieId.setPath("/");
		response.addCookie(cookieId);
		
		String resultId=adminService.findByIdAndPwd(id, password);
		if(resultId==null||resultId.isEmpty()) {
			return "0";
		}else {
			return resultId;
		}	
	}
	
	@RequestMapping(value="/{adminId}",method=RequestMethod.GET)//转到管理界面
	public String toAdmin(@PathVariable String adminId,HttpServletRequest request) {
		//获取cookie
		Cookie[] cookies=request.getCookies();
		try{
			fileHandler.getAdminAvatar(adminId,request);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//判断是否存在cookie，若无，则到登录页面
		if(null==cookies) {
			return "redirect:/admin";
		}else {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("adminId")) {
					Admin admin=adminService.getInfoById(adminId);
					request.setAttribute("adminName", admin.getName());
					request.setAttribute("randomNum", Math.random());//通过随机数来不让浏览器从缓存读图片
					return "admin";
				}
			}
		}
		
		return "redirect:/admin";
	}
}
