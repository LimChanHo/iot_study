package com.test.exam;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class Exam2 {

	private HashMap<String, String> hm = new HashMap<String, String>();

	public String attr(String key){
		if(hm.containsKey(key)){
			return hm.get(key);
		}
		return null;
	}
	public void attr(String key, String value){
		hm.put(key, value);
	}
	
	public static void main(String[] args){
		Exam2 e = new Exam2();
		e.attr("abc","1");
		String str = e.attr("abc");
		System.out.println(str);
		
		int[] arrNum = new int[5];
		String[] arrStr = {"1","2"};
		JSONObject jo = new JSONObject();
	}
}
