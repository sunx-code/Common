package com.sunx.common.memory;

import java.lang.management.ClassLoadingMXBean;  
import java.lang.management.ManagementFactory;  
import java.lang.management.MemoryMXBean;  
  
public class SystemInfoUtils {  
  
    private SystemInfoBean infoBean = null;  
  
    private static class SingletonClassInstance {  
        private static final SystemInfoUtils instance = new SystemInfoUtils();  
    }  
  
    public static SystemInfoUtils getInstance() {  
        return SingletonClassInstance.instance;  
    }  
  
    private SystemInfoUtils() {  
        infoBean = new SystemInfoBean();  
    }  
  
    public SystemInfoBean getSystemInfo() {  
        // 类信息  
        ClassLoadingMXBean classLoadMXBean = ManagementFactory  
                .getClassLoadingMXBean();  
        int loadClazzCount = classLoadMXBean.getLoadedClassCount();  
        infoBean.setLoadClazzCount(loadClazzCount);  
        long hasloadClazzCount = classLoadMXBean.getTotalLoadedClassCount();  
        infoBean.setHasloadClazzCount(hasloadClazzCount);  
        long hasUnloadClazzCount = classLoadMXBean.getUnloadedClassCount();  
        infoBean.setHasUnloadClazzCount(hasUnloadClazzCount);  
  
        // 内存  
        MemoryMXBean memoryUsage = ManagementFactory.getMemoryMXBean();  
        infoBean.setHeapMemoryUsage(memoryUsage.getHeapMemoryUsage());  
        infoBean.setNonHeapMemoryUsage(memoryUsage.getNonHeapMemoryUsage());  
        return infoBean;  
    } 
    public static void main(String[] args) {
		System.err.println(SystemInfoUtils.getInstance().getSystemInfo().toString());
	}
} 