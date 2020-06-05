package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class TestController {
	
	
	@ResponseStatus
	(value=HttpStatus.BAD_REQUEST, reason="No Odd Number Allowed.") 
	public class NoOddNumberException extends Exception {    
		public NoOddNumberException(int num) {        
			super(num + "은 홀수입니다.");    
		} 
	}
	
	@GetMapping("/error_no_odd_number2") 
	@ResponseBody public String noOddNumber2(@RequestParam("num") Integer num) 
	throws NoOddNumberException {
		if((num % 2) != 0) { 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "홀수 사용은 허 용되지 않음. (입력값 : " + num + ")");
		}    
		return num + ""; 
	}
	 @GetMapping("/error_arithmetic")    
	 @ResponseBody    
	 public String doArithmetic() {
		 return (10 / 0) + "";    
	 }        
	 // 이 컨트롤러의 내부에서 일어나는 ArithmeticException, ClassCastException은 모두 여기서 처리    
	 @ExceptionHandler({ ArithmeticException.class, ClassCastException.class })    
	 // 돌려줄 HTTP 코드 (에러와 관련된 코드 권장, 생략하면 200 OK가 반환되므로 주의!)    
	 @ResponseStatus(HttpStatus.BAD_REQUEST)    
	 public String arithmeticAndClassCastError(Model m, Exception ex) {
		 m.addAttribute("cause", ex.getMessage());                
		 // 에러가 일어났을 때 이동할 뷰 지정        
		 if(ex instanceof ArithmeticException) {
			 return "/myerror/error_arithmetic";        
		 } else {
			 return "/myerror/error_classcast";        
		 }    
	}
	// com.example.spring_lec4.example 패키지와 그 하위 패키지의 컨트롤러 에러를 처리 
	 @ControllerAdvice("com.example.spring_lec4.example") 
	 public class GlobalExceptionHandler {    
		 @ExceptionHandler(value=ArithmeticException.class)    
		 @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)    
		 public String globalArithmeticError(Model m, Exception ex) {
			 System.out.println("Global arithmetic error handler");
			 m.addAttribute("cause", ex.getMessage());
			 return "/myerror/error_global_arithmetic";    
		}        
		 @ExceptionHandler(value=Exception.class)    
		 @ResponseStatus(HttpStatus.CONFLICT)    
		 public String globalErrorHandler(Model m, HttpServletRequest req, Exception ex) throws Exception {
			 System.out.println("from Global error handler");
			 m.addAttribute("cause", ex.getMessage());
			 return "/myerror/error_global";    
		}
	 }
}
