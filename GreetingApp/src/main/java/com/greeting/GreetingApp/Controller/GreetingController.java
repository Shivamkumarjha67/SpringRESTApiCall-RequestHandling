package com.greeting.GreetingApp.Controller;

import com.greeting.GreetingApp.Model.Greeting;
import com.greeting.GreetingApp.Service.GreetingAppService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private final GreetingAppService greetingAppService;

	GreetingController(GreetingAppService greetingAppService) {
		this.greetingAppService = greetingAppService;
	}
	// Uc4 task
	@PostMapping("/save")
	public Greeting saveGreeting(@RequestParam String message) {
		return greetingAppService.saveGreeting(message);
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
