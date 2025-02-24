package com.greeting.GreetingApp.Service;

import org.springframework.stereotype.Service;

@Service
public class GreetingAppService {
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
