package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
	
	@GetMapping("/model")
	public String model(Model m) { // 파라미터에 Model 타입 값 받음
	// addAttribute(String, Object)
		m.addAttribute("title", "Hello World 1234"); // 뷰(템플릿) 내부에 필요한 내용 채우기
		m.addAttribute("content", "Content 1234");
		
		return "with_model"; // 역시 템플릿 이름 리턴
	}
	
	@GetMapping("model_and_view")
	public ModelAndView modelAndView() { // 반환 타입이 ModelAndView
		ModelAndView m = new ModelAndView("with_model"); // 뷰(템플릿) 이름 지정
		// addObject(String, Object)
		m.addObject("title", "Hello World 1234");
		m.addObject("content", "Content 1234");
		
		return m;
	}


}
