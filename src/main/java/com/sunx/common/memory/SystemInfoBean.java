package com.sunx.common.memory;

import java.lang.management.MemoryUsage;
import java.util.Date;

public class SystemInfoBean {
	// 加载类的数量
	public int loadClazzCount;
	// 已经加载类的数量
	public long hasloadClazzCount;
	// 尚未加载类的数量
	public long hasUnloadClazzCount;
	// 堆内存信息
	public MemoryUsage heapMemoryUsage;
	// 非堆内存信息
	public MemoryUsage nonHeapMemoryUsage;
	// JVM启动时间
	public Date startTime;
	//内存使用总数
	private long totalUsed;
	
	public int getLoadClazzCount() {
		return loadClazzCount;
	}
	public void setLoadClazzCount(int loadClazzCount) {
		this.loadClazzCount = loadClazzCount;
	}
	public long getHasloadClazzCount() {
		return hasloadClazzCount;
	}
	public void setHasloadClazzCount(long hasloadClazzCount) {
		this.hasloadClazzCount = hasloadClazzCount;
	}
	public long getHasUnloadClazzCount() {
		return hasUnloadClazzCount;
	}
	public void setHasUnloadClazzCount(long hasUnloadClazzCount) {
		this.hasUnloadClazzCount = hasUnloadClazzCount;
	}
	public MemoryUsage getHeapMemoryUsage() {
		return heapMemoryUsage;
	}
	public void setHeapMemoryUsage(MemoryUsage heapMemoryUsage) {
		this.heapMemoryUsage = heapMemoryUsage;
	}
	public MemoryUsage getNonHeapMemoryUsage() {
		return nonHeapMemoryUsage;
	}
	public void setNonHeapMemoryUsage(MemoryUsage nonHeapMemoryUsage) {
		this.nonHeapMemoryUsage = nonHeapMemoryUsage;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public long getTotalUsed() {
		return totalUsed;
	}
	public void setTotalUsed(long totalUsed) {
		this.totalUsed = totalUsed;
	}
	@Override
	public String toString() {
		return
				"加载类的数量:" + loadClazzCount + "\n" + 
				"已经加载类的数量:" + hasloadClazzCount + "\n" + 
				"尚未加载类的数量:" + hasUnloadClazzCount + "\n" + 
				"堆内存初始化大小:" + heapMemoryUsage.getInit() + "\n" + 
				"堆内存已使用大小:" + heapMemoryUsage.getUsed() + "\n" + 
				"堆内存已申请最大值:" + heapMemoryUsage.getCommitted() + "\n" + 
				"堆内存上限:" + heapMemoryUsage.getMax() + "\n" + 
				"非堆内存初始化大小:" + nonHeapMemoryUsage.getInit() + "\n" + 
				"非堆内存已使用大小:" + nonHeapMemoryUsage.getUsed() + "\n" + 
				"非堆内存已申请最大值:" + nonHeapMemoryUsage.getCommitted() + "\n" + 
				"非堆内存上限:" + nonHeapMemoryUsage.getMax() + "\n" + 
				"JVM启动时间:" + startTime;
	}
}