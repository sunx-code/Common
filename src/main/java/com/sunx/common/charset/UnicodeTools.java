package com.sunx.common.charset;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * unicode的转码工具
 *
 * 1 toStr:将uniocde编码数据转为字符串
 * 2 toUnicode:将字符串转化为unicode
 *
 */
public class UnicodeTools {
	/**
	 * 将字符串转化为unicode
	 * @param str		待转化字符串
	 * @return
     */
	public static String toUicode(String str){
		if(str == null)return null;
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			unicode.append("\\u");
			int j = (c >>>8); //取出高8位
			String tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				unicode.append("0");
			unicode.append(tmp);
			j = (c & 0xFF); //取出低8位
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				unicode.append("0");
			unicode.append(tmp);
		}
		return unicode.toString();
	}

	/**
	 * 将uniocde编码数据转为字符串
	 * @param unicode		待处理unicode字符串
	 * @return
     */
	public static String toStr(String unicode){
		Charset set = Charset.forName("UTF-16");
		Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
		Matcher m = p.matcher(unicode);
		int start = 0;
		int start2 = 0;
		StringBuffer buff = new StringBuffer();
		while(m.find(start)){
			start2 = m.start() ;  
            if( start2 > start ){  
                String seg = unicode.substring(start, start2) ;  
                buff.append( seg );
            }
            String code = m.group( 1 );  
            int i = Integer.valueOf( code , 16 );  
            byte[] bb = new byte[ 4 ] ;  
            bb[ 0 ] = (byte) ((i >> 8) & 0xFF );  
            bb[ 1 ] = (byte) ( i & 0xFF ) ;  
            ByteBuffer b = ByteBuffer.wrap(bb);  
            buff.append( String.valueOf( set.decode(b)).trim());  
            start = m.end() ;
		}
		start2 = unicode.length() ;  
        if( start2 > start ){  
            String seg = unicode.substring(start, start2) ;  
            buff.append( seg );  
        }  
        return buff.toString() ;
	}
}