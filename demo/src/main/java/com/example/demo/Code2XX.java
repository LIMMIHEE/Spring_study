package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Code2XX {
	 private Integer percent = 0;    private Integer id = 1; 
      
	 @RequestMapping("/c200")    
	 public String c200(HttpServletResponse response) {        
		 response.setStatus(200);               
		 return "OK";    
	} 
	 
	 @RequestMapping("/c201")    
	 public String c201(HttpServletResponse response) {       
		 response.setStatus(201);        // 3XX 코드가 아니므로 브라우저 상 리다이렉션은 일어나지 않으나 응답 헤더에는 포함 됨        
		 response.setHeader("Location", "http://www.naver.com");                
		 return "Accepted";    
	}       
	 @RequestMapping("/c202")   
	 public void c202(HttpServletResponse response) throws IOException {        
		 response.setStatus(202);// setContentType 메소드 내부적으로는  setHeader 메소드를 호출함        
		 // https://alvinalexander.com/java/jwarehouse/eclipse/org.eclipse.equinox.http/src/ org/eclipse/equinox/http/servlet/HttpServletResponseImpl.java.shtml        
		 response.setContentType("application/json");        
		 // response.setCharacterEncoding("utf-8");                
		 response.setHeader("Content-Type", "application/json; charset=utf-8");// response.setContentLength(1);
		 // 이렇게 썼을 경우 달라지는 결과 확인해보기               
		 response.getWriter().append("{ \"url\": \"/async_job/" + id + "\" }");
	 	 id++;                // 뭔가 오래 걸리는 작업 진행        
	 	 new Thread(new Runnable() {            
	 		 @Override            
	 		 public void run() {               
	 			 try {                    
	 				 while(true) {                        
	 					 Thread.sleep(1000);                        
	 					 percent += 10;                        
	 					 System.out.println("percent : " + percent);                       
	 					 if(percent == 100) break;                    
	 				}                
	 			} catch (InterruptedException e) {}           
	 	}        }).start();                
	 	 return;    } 
}
