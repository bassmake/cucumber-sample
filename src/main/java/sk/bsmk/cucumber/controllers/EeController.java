package sk.bsmk.cucumber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.bsmk.cucumber.services.HelloService;

import java.util.Optional;

/**
 * Created by miroslav.matejovsky on 08/10/15.
 */
@RestController
public class EeController {

  private final HelloService helloService;

  @Autowired
  public EeController(HelloService helloService) {
    this.helloService = helloService;
  }

  @RequestMapping("/")
  public String hello() {
    return helloService.createHello(Optional.empty());
  }

  @RequestMapping("/{name}")
  public String helloWithName(
      @PathVariable String name
  ) {
    return helloService.createHello(Optional.of(name));
  }

}
