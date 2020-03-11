package org.uzgoto.experimental.services;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

@Service
public class MultiThreadExecutorService implements Runnable, AutoCloseable {
  private static final ExecutorService executor = Executors.newWorkStealingPool();

  @Override
  public void run() {
    var tasks = new ArrayList<Future<?>>(100);
    for (var i = 0; i < 100; i++) {
      final var counter = i;
      System.out.println("Worker" + counter + " start.");
      tasks.add(executor.submit(() -> this.heavy(counter)));
    }
  }

  @Override
  public void close() throws Exception {
    System.out.println("Start to shutdown.");
    executor.shutdown();
    while (!executor.isTerminated()) {
      System.out.println("Terminating...");
      Thread.sleep(1_000);
    }
    executor.shutdownNow();
    System.out.println("Completed to shutdown.");
  }

  public void heavy(int i) {
    try {
      System.out.println("Worker" + i + " Thread" + Thread.currentThread().getId() + " is started.");
      Thread.sleep(1_000);
      System.out.println("Worker" + i + " Thread" + Thread.currentThread().getId() + " is ended.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
