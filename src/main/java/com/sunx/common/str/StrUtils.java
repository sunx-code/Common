package com.sunx.common.str;

import java.lang.reflect.Field;

public class StrUtils {
	
	public static <T> String toString(T t){
		Field[] fields = t.getClass().getDeclaredFields();
		StringBuffer buff = new StringBuffer();
		buff.append("-------------------------------\n");
		for(Field field : fields){
			field.setAccessible(true);
			try {
				buff.append(field.getName() + ":" + field.get(t) + "\n");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		buff.append("------------------------------------------------\n");
		return buff.toString();
	}
}