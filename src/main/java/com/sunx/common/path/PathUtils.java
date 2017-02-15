package com.sunx.common.path;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

public class PathUtils {
	/**
	 * getJarPath  获取的是绝对路径
	 * @return String
	 * @exception
	 * @since  1.0.0
	 */
	public static String getJarPath(){
		URL url = PathUtils.class.getProtectionDomain().getCodeSource().getLocation();  
	    String filePath = null;  
	    try {  
	        filePath = URLDecoder.decode(url.getPath(), "utf-8");// 转化为utf-8编码  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    if (filePath.endsWith(".jar")) {// 可执行jar包运行的结果里包.jar"  
	        // 截取路径中的jar包名  
	        filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);  
	    }
	      
	    File file = new File(filePath);  
	    filePath = file.getAbsolutePath();//得到windows下的正确路径  
	    
	    return filePath + "/"; 
	}
}