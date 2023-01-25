package com.example.moonsunstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  기본적으로 Spring 프로젝트는 8080 포트로 올라간다.
 *  수정하고 싶으면 resource 폴더에 application.yml 파일을 만들어서 수정하면 된다.
 */

@RestController // @Component -> 해당 클래스를 Bean 으로 등록하겠다!
public class HealthCheckController {

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}

}
