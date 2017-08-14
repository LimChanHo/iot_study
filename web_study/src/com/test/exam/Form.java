package com.test.exam;

public class Form {
	Element[] elements = new Element[3];
	
	Form(){
		elements[0] = new Element();
		elements[1] = new Element();
		elements[2] = new Element();
	}
	public static void main(String[] args){
		Form fObj = new Form();
		
		int maxNum = fObj.elements.length;
		for(int i=0;i<maxNum;i++){
			Element e = fObj.elements[i];
			e.value = ""+i;
		}
	}
}
