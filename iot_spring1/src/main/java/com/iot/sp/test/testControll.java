package com.iot.sp.test;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class testControll {
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		
		return "test/list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,@RequestParam(value="ttt",required=false) String ttt){
		
		return "test/write";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,@RequestParam(value="ttt",required=false) String ttt){
		
		return "test/modify";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,@RequestParam(value="ttt",required=false) String ttt){
		
		return "test/delete";
	}
	
}
	