package org.uzgoto.experimental.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.uzgoto.experimental.services.PrintPropertiesService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DemoController implements CommandLineRunner {
  private final PrintPropertiesService printPropertiesService;
  private final RetryService retryService;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Read properties.");
    System.out.println("==========");
    printPropertiesService.print();
    System.out.println("==========");

    System.out.println("Run and retry.");
    retryService.run();
  }
}
