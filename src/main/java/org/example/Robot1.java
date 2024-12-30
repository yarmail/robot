package org.example;


/**
 * Более классический вариант решения с помощью wait() и notify()
 */
public class Robot1 implements Runnable {

  private final Object lock = new Object();
  private boolean isRightLegTurn = true;

  public void run() {
    while (true) {
      synchronized (lock) {
        // Определяем, какая нога должна шагать
        while ((isRightLegTurn && Thread.currentThread().getName().equals("Левая нога")) ||
          (!isRightLegTurn && Thread.currentThread().getName().equals("Правая нога"))) {
          try {
            lock.wait(); // Ожидаем своего хода
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстановление прерывания
          }
        }

        // Шагаем
        System.out.println(Thread.currentThread().getName());
        isRightLegTurn = !isRightLegTurn; // Меняем ногу
        lock.notifyAll(); // Уведомляем другие потоки
      }

      try {
        Thread.sleep(3000); // Задержка для имитации шага
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // Восстановление прерывания
      }
    }
  }

  public static void main(String[] args) {
    Robot1 robot1 = new Robot1();
    Thread rightLegThread = new Thread(robot1, "Правая нога");
    Thread leftLegThread = new Thread(robot1, "Левая нога");

    rightLegThread.start();
    leftLegThread.start();
  }
}
