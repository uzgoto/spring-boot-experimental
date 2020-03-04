package org.uzgoto.experimental.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;


@EnableRetry
public class RetryService {

  @Retryable(value = IOException.class, maxAttempt = 5, backoff = @Backoff(delay = 1000))
  public void print() {
    var content = Files.newInputStream(Paths.get("C:\\workspace\\foo.bar")).readAllBytes();
    System.out.println(Base64.getEncoder().encodeToString(content));
  }

  @Recover
  void recoverPrint() {
    System.out.println("retry max attempts is over.");
  }
}
