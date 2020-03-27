package org.uzgoto.experimental.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.uzgoto.experimental.services.MultiThreadExecutorService;
import org.uzgoto.experimental.services.PrintPropertiesService;
import org.uzgoto.experimental.services.RetryService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DemoController implements CommandLineRunner {
  private final PrintPropertiesService printPropertiesService;
  private final RetryService retryService;
  private final MultiThreadExecutorService executorService;

  static {
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Add shutdown hook.");
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      try {
        System.out.println("Start shutdown hook.");
        executorService.close();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        System.out.println("End shutdown hook.");
      }
    }));

    System.out.println("Read properties.");
    System.out.println("==========");
    printPropertiesService.print();
    System.out.println("==========");

    System.out.println("Run and retry.");
    System.out.println("==========");
    retryService.print();
    System.out.println("==========");

    System.out.println("Run executor.");
    System.out.println("==========");
    executorService.run();
    Thread.sleep(8_256);
    ProcessHandle.current().destroyForcibly();
    System.out.println("==========");
  }
}
