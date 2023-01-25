package com.example.moonsunstudy.interceptor;

import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j // Lombok 에서 Log 를 찍는 도구인 Logger 를 자동으로 만들어준다.
public class StopWatchInterceptor implements HandlerInterceptor {

	private final StopWatch stopWatch;

	public StopWatchInterceptor() {
		this.stopWatch = new StopWatch();
	}

	// TODO : return true 에 대해서는 Chain 에 대한 이해를 한 후에 정리하도록 한다.
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		stopWatch.start();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView) throws Exception {
		stopWatch.stop();

		// 어떤 API 를 호출했을 때 소요시간인지까지 보여주고 싶다.
		// EX) GET /ping - 소요시간 : 69ms
		// GET /ping -> HTTP Request -> 객체(HttpServletRequest)
		log.info("========= " + req.getMethod() + " " + req.getRequestURI() + " =========");
		log.info("소요시간 : " + stopWatch.getLastTaskTimeMillis() + "ms");
		log.info("========================");
	}

}
