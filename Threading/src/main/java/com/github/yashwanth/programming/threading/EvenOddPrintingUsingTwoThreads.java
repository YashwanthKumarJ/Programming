package com.github.yashwanth.programming.threading;

public class EvenOddPrintingUsingTwoThreads {

    private final int max;

    private int count = 0;

    public EvenOddPrintingUsingTwoThreads(int max) {
        this.max = max;
    }

    public void startPrinting() {
        Thread t1 = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("Even Thread");

        Thread t2 = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.setName("Odd Thread");

        t1.start();
        t2.start();
    }

    public void printEven() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (count % 2 != 0) {
                    wait();
                }

                if (count <= max) {
                    System.out.println(Thread.currentThread().getName() + " " + count);
                } else {
                    count++;
                    notify();
                    break;
                }

                count++;
                notify();
            }
        }
    }

    public void printOdd() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (count % 2 == 0) {
                    wait();
                }

                if (count <= max) {
                    System.out.println(Thread.currentThread().getName() + " " + count);
                } else {
                    count++;
                    notify();
                    break;
                }

                count++;
                notify();
            }
        }
    }
}
