package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello"; //html 파일 부름
	}
	
	@RequestMapping(value="/bye", method=RequestMethod.GET)
	public String bye() {
		return "<h1>bye</h1>";
	}
	
	@RequestMapping(value="/POST", method= {RequestMethod.POST,RequestMethod.GET})
	public String POST() {
		return "<h1>bye</h1>";
	}
	
	@PostMapping("post2")
	public String post2(){
		return "<h1>TEST</h1><hr>";
	}
}
