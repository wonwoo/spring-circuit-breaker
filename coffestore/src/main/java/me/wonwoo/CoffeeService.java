package me.wonwoo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by wonwoolee on 2017. 5. 29..
 */
@Service
public class CoffeeService {

  private final RestTemplate restTemplate;

  public CoffeeService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @HystrixCommand(fallbackMethod = "fallback",  commandProperties = {
      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "2000"),
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
  public String coffees() {
    return this.restTemplate.getForObject(URI.create("http://localhost:9090/coffees"), String.class);
  }

  public String fallback() {
    return "Cappuccino";
  }
}
