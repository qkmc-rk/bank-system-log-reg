package com.bank.utils;
import java.util.HashMap;
import java.util.Map;
public class Container {
	/*定义一个全局Map，用来保存全局使用的数据*/
	private static Map<String, Object> datas = new HashMap<>();
	/*保存全局值*/
	public static void register(String name, Object object){
		datas.put(name, object);
	}
	/*获取全局值*/
	public static Object getObject(String name){
		return datas.get(name);
	}
}
