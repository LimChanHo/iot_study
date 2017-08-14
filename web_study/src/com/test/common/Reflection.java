package com.test.common;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.test.dto.BoardInfo;
import com.test.dto.Cal;
public class Reflection {

	public static void main(String[] agrs){
		try {
			Class c = Class.forName("com.test.dto.Cal");
			Method[] m = c.getMethods();
			for(int i=0;i<m.length;i++){
//				System.out.println(m[i].getName());
			}
			Method m2 = c.getDeclaredMethod("setOp", String.class);
			Cal cal = (Cal)c.newInstance();
			m2.invoke(cal, "+");
			System.out.println(cal.getOp());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
