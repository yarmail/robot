package org.example;

import lombok.SneakyThrows;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Другой вариант решения с помощью ReentrantLock
 */
public class Robot2 implements Runnable {

  private String currentLeg = "Правая нога";
  private final ReentrantLock lock = new  ReentrantLock();
  private static AtomicLong counter = new AtomicLong(0);

  @SneakyThrows
  public void run(){
    while (true) {
      counter.addAndGet(1);
      String leg = Thread.currentThread().getName();
      if (leg.equals(currentLeg)) {
        lock.lock();
        System.out.println(leg);
        Thread.sleep(1000);
        if (currentLeg.equals("Правая нога")) {
          currentLeg = "Левая нога";
        } else {
          currentLeg = "Правая нога";
        }
        lock.unlock();
        // System.out.println(counter);
      }
    }
  }

  public static void main(String[] args) {
    Robot2 robot2 = new Robot2();
    Thread thread1 = new Thread(robot2, "Правая нога");
    thread1.start();

    Thread thread2 = new Thread(robot2, "Левая нога");
    thread2.start();
  }
}

/* Примечание
System.out.println(counter);
Включите, если хотите посмотреть сколько циклов пропускается

 */