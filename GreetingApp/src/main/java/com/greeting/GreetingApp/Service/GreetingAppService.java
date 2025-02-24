package com.greeting.GreetingApp.Service;

import com.greeting.GreetingApp.Model.Greeting;
import com.greeting.GreetingApp.Repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingAppService {
    // DI
    private final GreetingRepository greetingRepository;
    // Using Constructor injection
    GreetingAppService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // UC8 task
    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }

    // UC7 task
    public Greeting updateGreeting(Long id, String message) {
        return greetingRepository.findById(id).map(greeting -> {
                    greeting.setMessage(message);
                    return greetingRepository.save(greeting);
                    }).orElse(null);
    }

    // UC6 task
    public List<Greeting> getAllGreetings() {
        List<Greeting> greetings = greetingRepository.findAll();
        System.out.println("Fetched Greetings: " + greetings);
        return greetings;
    }

    // UC5 task
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    // Uc4 task
    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    // UC3 task
    public String getGreetingWithName(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        }

        return getMessage();
    }

    // UC2 task
    public String getMessage() {
        return "Greeting from Service layer...";
    }
}
