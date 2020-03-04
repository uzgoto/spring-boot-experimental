package org.uzgoto.experimental.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@EnableRetry
public class RetryService {

  @Retryable(value = IOException.class, maxAttempts = 5, backoff = @Backoff(delay = 1000))
  public void print() throws IOException {
    System.out.println("Try to reading file.");
    var content = Files.newInputStream(Paths.get("C:\\workspace\\foo.bar")).readAllBytes();
    System.out.println(Base64.getEncoder().encodeToString(content));
  }

  @Recover
  public void recoverPrint() {
    System.out.println("retry max attempts is over.");
  }
}
