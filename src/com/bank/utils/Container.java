package com.bank.utils;
import java.util.HashMap;
import java.util.Map;
public class Container {
	/*����һ��ȫ��Map����������ȫ��ʹ�õ�����*/
	private static Map<String, Object> datas = new HashMap<>();
	/*����ȫ��ֵ*/
	public static void register(String name, Object object){
		datas.put(name, object);
	}
	/*��ȡȫ��ֵ*/
	public static Object getObject(String name){
		return datas.get(name);
	}
}
