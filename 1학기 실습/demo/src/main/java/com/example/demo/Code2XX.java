package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Code2XX {
	private Integer percent = 0;
	private Integer id = 1;
	
	
	@RequestMapping("/c200")
	public String c200(HttpServletResponse response) {
		response.setStatus(200);
		return "OK";
	}
	
	@RequestMapping("/c201")
	public String c201(HttpServletResponse response) {
	response.setStatus(201);
	// 3XX 코드가 아니므로 브라우저 상 리다이렉션은 일어나지 않으나 응답 헤더에는 포함됨
	response.setHeader("Location", "http://www.naver.com");
	return "Accepted";
	}

}
