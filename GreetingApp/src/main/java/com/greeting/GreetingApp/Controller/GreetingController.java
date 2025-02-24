package com.greeting.GreetingApp.Controller;

import com.greeting.GreetingApp.Model.Greeting;
import com.greeting.GreetingApp.Service.GreetingAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	private final GreetingAppService greetingAppService;

	GreetingController(GreetingAppService greetingAppService) {
		this.greetingAppService = greetingAppService;
	}

	// UC8 task
	//UC_08
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteGreeting(@PathVariable Long id) {
		greetingAppService.deleteGreeting(id);
		return ResponseEntity.ok("Greeting deleted successfully.");
	}

	// UC7 task
	@PutMapping("/update/{id}")
	public Greeting updateGreetingMessage(@PathVariable Long id, @RequestParam String message) {
		return greetingAppService.updateGreeting(id, message);
	}

	// UC6 task
	@GetMapping("/allMessages")
	public List<Greeting> getAllGreetings() {
		//Call Service method
		return greetingAppService.getAllGreetings();
	}

	// UC5 task
	@GetMapping("/{id}")
	public Greeting getGreetingById(@PathVariable Long id) {
		return greetingAppService.getGreetingById(id);
	}

	// UC4 task
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
