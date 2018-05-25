package com.fourth.util;

import org.springframework.stereotype.Component;

@Component
public class DataHandler {

	public String encrypt(String data) {
		char[] chars=data.toCharArray();
		for(int i=0;i<chars.length;i++) {
			chars[i]=(char)(chars[i]^2000);
		}
		return new String(chars);
	}
	
	public String decrypt(String data) {
		char[] chars=data.toCharArray();
		for(int i=0;i<chars.length;i++) {
			chars[i]=(char)(chars[i]^2000);
		}
		return new String(chars);
	}
}
