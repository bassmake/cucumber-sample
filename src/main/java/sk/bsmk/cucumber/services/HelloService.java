package sk.bsmk.cucumber.services;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by miroslav.matejovsky on 15/10/15.
 */
@Service
public class HelloService {

  public String createHello(Optional<String> name) {
    return name.map(s -> String.format("hello %s", s)).orElse("hello");
  }

}
