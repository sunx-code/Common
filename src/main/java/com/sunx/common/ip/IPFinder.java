package com.sunx.common.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class IPFinder {
	/**
	 * 获取本机ip地址,并自动区分Windows还是linux操作系统
	 * 
	 * @return String
	 * @throws  
	 */
	public static String getIP(){
		 List<String> ipList = new ArrayList<String>();
        InetAddress ip;
    	try {
    		 Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
             while (netInterfaces.hasMoreElements()) {
             	NetworkInterface ni = netInterfaces.nextElement();
             	//----------特定情况，可以考虑用ni.getName判断
             	//遍历所有ip
             	Enumeration<InetAddress> ips = ni.getInetAddresses();
             	while (ips.hasMoreElements()) {
             		ip = ips.nextElement();
             		 if (ip.isSiteLocalAddress()
                             && !ip.isLoopbackAddress()   //127.开头的都是lookback地址
                             && ip.getHostAddress().indexOf(":") == -1) {
                         ipList.add(ip.getHostAddress());
                     }
             	}
             }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	if (ipList.size() == 0) {
            try {
				throw new Exception("Can't find this computer IP address Exception.");
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        Collections.sort(ipList);
        return ipList.get(0);
    }
	public static void main(String[] args) {
		try {
			System.out.println("get ip is:" + getIP());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}