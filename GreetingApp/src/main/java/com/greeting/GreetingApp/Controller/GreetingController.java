package com.greeting.GreetingApp.Controller;

import com.greeting.GreetingApp.Service.GreetingAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private final GreetingAppService greetingAppService;

	GreetingController(GreetingAppService greetingAppService) {
		this.greetingAppService = greetingAppService;
	}

	@GetMapping("/message")
	public String getServiceMessage() {
		return greetingAppService.getMessage();
	}

	@GetMapping
	public String getGreeting() {
		return "Welcome to the greeting app!";
	}
}
