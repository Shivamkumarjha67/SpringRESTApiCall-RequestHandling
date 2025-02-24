package com.greeting.GreetingApp.Repository;

import com.greeting.GreetingApp.Model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}