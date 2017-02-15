package com.sunx.common.process;

import java.io.IOException;

public class BatExecute {
	public static void exec(String path){
		try {
			if(isWin()){
				runbat("cmd.exe /c \"start " + path +"\"");
			}else{
				runbat("sh " + path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void runbat(String batName) {
        try {
            Runtime.getRuntime().exec(batName);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	public static boolean isWin(){
		if(System.getProperty("os.name").toLowerCase().startsWith("win"))return true;
		return false;
	}
}