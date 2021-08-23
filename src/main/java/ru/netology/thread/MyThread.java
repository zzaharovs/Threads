package ru.netology.thread;

public class MyThread extends Thread {

    public MyThread(ThreadGroup group, String threadName) {
        super(group, threadName);
    }

    @Override
    public void run() {

        try {
            while (!isInterrupted()) {
                Thread.sleep(1000);
                System.out.printf("Я %s. Всем привет! \n", getName());
            }
        } catch (InterruptedException ignored) {
        }
        finally {
            System.out.printf("%s завершен\n", getName());
        }
    }
}
