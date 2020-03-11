package org.uzgoto.experimental;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
  static ConfigurableApplicationContext ctx;
  public static void main(String[] args) {
    ctx = SpringApplication.run(DemoApplication.class, args);
    System.out.println("Pre register shutdown hook.");
    ctx.registerShutdownHook();
    System.out.println("Post register shutdown hook.");
  }

  @PreDestroy
  static void onExit() {
    System.out.println("Start preDestroy.");
    System.out.println("End preDestroy.");
  }
}
