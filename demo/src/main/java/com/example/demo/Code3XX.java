package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Code3XX {
	@RequestMapping("/c301") 
	public String c301(HttpServletResponse response) {
		response.setStatus(301);    
		response.setHeader("Location", "http://www.naver.com");        
		// 일반적으로 redirect 응답에는 바디를 포함하지 않음 (그러나 금지는 아님)    
		// https://stackoverflow.com/questions/8059662/http-302-redirect-is-amessage-body-needed    
		return "Moved Permanently"; 
	}
	/*
	@RequestMapping("/c302") 
	public void c302(HttpServletResponse response) throws IOException {
		response.setHeader("Location", "http://www.naver.com");
		//일시적으로 바뀌는 거라 이동하지는 ..않음? 아마.
	}
	*/
	/*
	@RequestMapping("/c302") 
	public RedirectView c302()  {
		return new RedirectView("http://www.naver.com");
		// 바로 보내줌
	}
	*/
	///*
	 @RequestMapping("/c302") 
	public ModelAndView c302()  {
		return new ModelAndView("redirect:http://www.naver.com");
		//사용할 템플릿 뷰의 이름을 지정하는 건데 그거에 주소를 넣어서  anj.. 잘 모르겠음 0514 영상 다시보기
	}
	// */
}
