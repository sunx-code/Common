package com.sunx.common.encrypt;

import java.security.MessageDigest;

/**
 * MD5工具包
 * 1 提供md的加密
 * 2 支持给定字符串进行加密
 * 3 支持给定字节数组进行加密
 *
 * 待加功能：
 * 1 支持最定义的长度
 */
public class MD5 {
	//加密字典
	private static char[] arrayOfChar1 = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };

	/**
	 * 根据给定的字符串来获取md5
	 *
	 * @param str 待加密字符串
	 * @return
     */
	public static String md5(String str){
		return md5(str.getBytes(),32);
	}

	/**
	 * 给定字符串和长度,进行加密
	 * @param str 待加密字符串
	 * @param len 加密结果长度
     * @return
     */
	public static String md5(String str,int len){
		return md5(str.getBytes(),len);
	}

	/**
	 * 给定一个字节数组和长度获取md
	 * @param bytes 待加密byte[]
	 * @param len   加密结果长度
     * @return
     */
	public static String md5(byte[] bytes,int len){
		try{
			if(len > 32 ||len < 1)return null;
			if(len % 2 == 1)throw  new Exception("len必须为偶数");
			String md5 = md5(bytes);
			if(md5 == null)return null;
			return md5.substring(16 - len/2,16 + len/2);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据给定的字节数组来获取md5
	 *
	 * @param bytes 字节数组
	 * @return
     */
	private static String md5(byte[] bytes) {
		try {
			MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
			localMessageDigest.update(bytes);
			byte[] arrayOfByte = localMessageDigest.digest();
			char[] arrayOfChar2 = new char[32];
			int i = 0;
			int j = 0;
			while (true) {
				if (i >= 16)
					return new String(arrayOfChar2);
				int k = arrayOfByte[i];
				int m = j + 1;
				arrayOfChar2[j] = arrayOfChar1[(0xF & k >>> 4)];
				j = m + 1;
				arrayOfChar2[m] = arrayOfChar1[(k & 0xF)];
				i++;
			}
		} catch (Exception localException) {
		}
		return null;
	}
}