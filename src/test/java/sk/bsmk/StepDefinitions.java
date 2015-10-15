package sk.bsmk;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import sk.bsmk.cucumber.services.HelloService;

import java.util.Optional;

/**
 * Created by miroslav.matejovsky on 08/10/15.
 */
@ContextConfiguration(classes = {
    HelloService.class
})
public class StepDefinitions {

  private static final Logger log = LoggerFactory.getLogger(StepDefinitions.class);

  @Autowired
  HelloService helloService;

  private TestRestTemplate restTemplate;
  private String name;

  @Given("I have rest template")
  public void i_have_rest_template() {
    restTemplate = new TestRestTemplate();
  }

  @And("My name is (.*)")
  public void my_name_is(String name) {
    this.name = name;
  }

  @Then("I receive hello message with my name")
  public void i_receive_hello_message() {
    final String helloMessage = restTemplate.getForObject("http://localhost:8085/" + name, String.class);
    final String expectedMessage = helloService.createHello(Optional.of(name));
    Assert.assertEquals(helloMessage, expectedMessage);
  }

}
