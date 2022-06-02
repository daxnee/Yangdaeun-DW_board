package com.dw.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component // 개발자(나)가 직접 작성한 class를 spring에게 Bean으로 등록하라는 뜻 
public class Interceptor implements HandlerInterceptor{

	// 메소드 자동 생성 기능 : Source -> Override/implements 메소드
	
	// preHandle : 컨트롤러에 도착하기 전에 요청을 가로채는 함수
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String url = request.getRequestURI();
		String ip = request.getHeader("x-forwarded-For"); // 클라이언트의 ip를 수집할 수 있다.
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		System.out.println("접속한 IP는 ====> " + ip);
		System.out.println("요청받은 url ====> " + url);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
