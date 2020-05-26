package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@GetMapping("student") 
	public String student(Model m) {    
		m.addAttribute("title", "Student page");// 메소드 시그니쳐 addAttribute(String, Object) 임을 주목, Object 이므로 어떤 클래스도 전 달 가능    
		m.addAttribute("student", new Student(1, "철수", "chulsoo@naver.com", false));       
		return "student";       
		
	}
	@RequestMapping("/request_param") 
	@ResponseBody
	public String requestParamTest(@RequestParam(value="name") String name) 
	{ 
		return name; 
	}
	@RequestMapping("/request_param2") 
	public String requestParamTest2(@RequestParam(value="name") String name, 
			@RequestParam(value="age", required=false) Integer age) {
			return name + "," + age; 
	}
	@RequestMapping("/request_param3") 
	@ResponseBody
	// Map<String, String> 
	public String requestParamTest3(@RequestParam Map<String, String> params) 
	{
		String result = "";    
		for(String key : params.keySet()) {        
			result += (key + "/" + params.get(key) + " ");    
		}     
		return result; 
	}
	@RequestMapping("/{width}/{height}") 
	@ResponseBody
	// Map<String, String> 
	public String img_Q(@PathVariable Integer width,
			@PathVariable Integer height, 
			@RequestParam(value="blur", required=false) Integer blur) 
	{
		 
		    return width+","+height+","+blur;
		
		
	}
	@GetMapping("student2") 
	public ModelAndView student2(Student s) { // 파라미터의 Student 타입을 주목   
			ModelAndView m = new ModelAndView("student");    
			m.addObject("title", "Student page");    
			m.addObject("student", s);        
			return m; 
	}

	@RequestMapping("/template2") 
	public String template2(Model m) {    
		m.addAttribute("value1", 100);    
		m.addAttribute("value2", "Hello, Paragraph!");        
		
		Book book = new Book("김철수", "부자되는 방법", 10000);    
		m.addAttribute("mybook", book);        
		return "template2"; 
	}
	@RequestMapping("/serve_static") 
	public String serveStatic() {    
		return "serve_static"; 
	}

}
