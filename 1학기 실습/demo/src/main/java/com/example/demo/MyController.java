package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping
	public String hello() {
		return "<h1>hello</h1>";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	@GetMapping("/student")
	public String student(Model m) {
		m.addAttribute("title", "Student page");
		// 메소드 시그니쳐 addAttribute(String, Object) 임을 주목, Object 이므로 어떤 클래스도 전달 가능
		m.addAttribute("student", new Student(1, "철수", "chulsoo@naver.com", false));
		return "student";
	}

	@RequestMapping("/request_param")
	@ResponseBody
	public String requestParamTest(@RequestParam(value="name") String name) {
		return name;
	}

	
	@GetMapping("/student/{a}")
	public String MulteTest(Model m,@PathVariable String a,@RequestParam(value="type") String
			type) {
		m.addAttribute("title", "Student page");
		// 메소드 시그니쳐 addAttribute(String, Object) 임을 주목, Object 이므로 어떤 클래스도 전달 가능
		m.addAttribute("student", new Student(1, a, type, false));
		return "student";
	}
}
