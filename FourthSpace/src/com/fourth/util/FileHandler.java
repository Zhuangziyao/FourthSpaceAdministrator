package com.fourth.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fourth.bean.Admin;
import com.fourth.service.AdminService;

@Component
public class FileHandler {
	@Autowired
	private AdminService adminService;
	
	public void setAdminAvatar(String filePath,String id) throws Exception{
		File f=new File(filePath);
		FileInputStream in=new FileInputStream(f);
		byte[] bytes=new byte[(int)f.length()];
		try {
			in.read(bytes);
		}finally {
			in.close();
		}
		Admin admin=new Admin();
		admin.setAdminId(id);
		admin.setAvatar(bytes);
		adminService.updateById(admin);
		
	}
	
	public void getAdminAvatar(String id,HttpServletRequest request) throws Exception {
		Admin admin=adminService.getInfoById(id);
		byte[] bytes=admin.getAvatar();
		StringBuilder str=new StringBuilder("F:\\JavaWork\\FourthSpace\\WebContent\\img");
		str.append("\\adminAvatar.jpg");
		FileOutputStream out=new FileOutputStream(str.toString());
		try {
			out.write(bytes);
		}finally {
			out.close();
		}
	}
}
