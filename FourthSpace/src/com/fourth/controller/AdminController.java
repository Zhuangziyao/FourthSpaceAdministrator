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
	
	@RequestMapping(value="",method=RequestMethod.GET)//ת����¼����
	public String adminLogin(HttpServletRequest request,@RequestParam(value="locale",defaultValue="zh_CN") String locale) {
		//Java���ʻ�
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
	
	@RequestMapping("/login")//�β����Ʊ�����form���е��ύname��ͬ
	@ResponseBody
	public String login(String id,String password,HttpServletRequest request,HttpServletResponse response) {
		//����cookie�����¼��¼
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
	
	@RequestMapping(value="/{adminId}",method=RequestMethod.GET)//ת���������
	public String toAdmin(@PathVariable String adminId,HttpServletRequest request) {
		//��ȡcookie
		Cookie[] cookies=request.getCookies();
		try{
			fileHandler.getAdminAvatar(adminId,request);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//�ж��Ƿ����cookie�����ޣ��򵽵�¼ҳ��
		if(null==cookies) {
			return "redirect:/admin";
		}else {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("adminId")) {
					Admin admin=adminService.getInfoById(adminId);
					request.setAttribute("adminName", admin.getName());
					request.setAttribute("randomNum", Math.random());//ͨ�������������������ӻ����ͼƬ
					return "admin";
				}
			}
		}
		
		return "redirect:/admin";
	}
}
