package ru.netology.thread;


public class Main {

    public static void main(String[] args) throws InterruptedException {


        ThreadGroup printGroup = new ThreadGroup("printGroup");

        final Thread thread1 = new MyThread(printGroup, "Поток 1");
        final Thread thread2 = new MyThread(printGroup, "Поток 2");
        final Thread thread3 = new MyThread(printGroup, "Поток 3");
        final Thread thread5 = new MyThread(printGroup, "Поток 5");


        System.out.println("Запускаю потоки");

        thread1.start();
        thread2.start();
        thread3.start();
        thread5.start();

        Thread.sleep(6000);

        System.out.println("Завершаю работу потоков");
        printGroup.interrupt();

    }

}
