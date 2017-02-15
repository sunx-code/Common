package com.sunx.common.files;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	public static void writer(String path,String encoding,String msg){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path),true),encoding));
			bw.write(msg);
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(bw != null){
					bw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void writerFileByLine(String path,String encoding,List<String> list){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path),true),encoding));
			for(String str : list){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(bw != null){
					bw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String readFile(File file,String encoding){
		BufferedReader br = null;
		StringBuffer buff = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),encoding));
			String line = null;
			while((line = br.readLine()) != null){
				if("".equals(line))continue;
				buff.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return buff.toString();
	}
	public static String readFile(String path,String encoding){
		BufferedReader br = null;
		StringBuffer buff = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),encoding));
			String line = null;
			while((line = br.readLine()) != null){
				if("".equals(line))continue;
				buff.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return buff.toString();
	}
	public static List<String> readFileByLine(String path,String encoding){
		BufferedReader br = null;
		List<String> list = new ArrayList<String>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),encoding));
			String line = null;
			while((line = br.readLine()) != null){
				if("".equals(line))continue;
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}