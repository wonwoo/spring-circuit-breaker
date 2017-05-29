package me.wonwoo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoolee on 2017. 5. 29..
 */
@RestController
public class CoffeeController {

  private final CoffeeService coffeeService;

  public CoffeeController(CoffeeService coffeeService) {
    this.coffeeService = coffeeService;
  }

  @GetMapping("/")
  public String coffees() {
    return coffeeService.coffees();
  }
}
