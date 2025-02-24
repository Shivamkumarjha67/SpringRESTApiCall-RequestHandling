package com.greeting.GreetingApp.Controller;

import com.greeting.GreetingApp.Service.GreetingAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private final GreetingAppService greetingAppService;

	GreetingController(GreetingAppService greetingAppService) {
		this.greetingAppService = greetingAppService;
	}

	// UC3 task
	//      route -->     localhost:9090/greeting/individual?firstName=Shivam&lastName=Kumar
	@GetMapping("/individual")
	public String getIndividualGreeting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
		return greetingAppService.getGreetingWithName(firstName, lastName);
	}

	// UC2 task
	@GetMapping("/message")
	public String getServiceMessage() {
		return greetingAppService.getMessage();
	}

	// UC1 task
	@GetMapping
	public String getGreeting() {
		return "Welcome to the greeting app!";
	}
}
