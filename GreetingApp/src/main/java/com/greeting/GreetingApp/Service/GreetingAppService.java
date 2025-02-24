package com.greeting.GreetingApp.Service;

import org.springframework.stereotype.Service;

@Service
public class GreetingAppService {
    public String getMessage() {
        return "Greeting from Service layer...";
    }
}
