// Opgave 2
package org.example;

public class MyThreadTask implements Runnable {

    private final int threadNumber;

    public MyThreadTask(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Hallo, Jeg hedder Thread #" + threadNumber);
    }
}
