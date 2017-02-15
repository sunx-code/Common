package com.sunx.common.encrypt;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncode {
	public static String decode(String src,String enc){
		try {
			return URLDecoder.decode(src, enc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encode(String src,String enc){
		try {
			return URLEncoder.encode(src, enc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
//		String text = "%7B%22pagesize%22%3A10%2C%22category_id%22%3A%2217%22%2C%22sort%22%3A%220%22%2C%22page%22%3A1%2C%22school_id%22%3A%22231%22%7D";
		String text = "%7B%22pagesize%22%3A10%2C%22category_id%22%3A%220%22%2C%22sort%22%3A%220%22%2C%22page%22%3A1%2C%22school_id%22%3A%22231%22%7D";
		
		String t = decode(text, "UTF-8");
		System.err.println(t);
		System.err.println(encode(text, "UTF-8"));
	}
}

