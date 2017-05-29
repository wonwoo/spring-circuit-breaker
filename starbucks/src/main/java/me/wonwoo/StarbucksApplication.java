package me.wonwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RestController
public class StarbucksApplication {

	@GetMapping("/coffees")
	String coffeeList(){
		try {
			TimeUnit.MILLISECONDS.sleep(950);
		} catch (InterruptedException e) {
		}
		return "Espresso, Cappuccino, Hazelnut";
	}

	public static void main(String[] args) {
		SpringApplication.run(StarbucksApplication.class, args);
	}
}
