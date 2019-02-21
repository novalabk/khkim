package com.example

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebApp {
	@RequestMapping("/")
	String greetings() {
		"스피링 부트 시작!"
	}
}
