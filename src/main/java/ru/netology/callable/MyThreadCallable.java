package ru.netology.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyThreadCallable implements Callable <Integer> {

    @Override
    public Integer call() {

        Random rand = new Random();
        int counter = 0;
        int taskDuration = 1 + (rand.nextInt(10) * rand.nextInt(10));

        try {
            for (int i = 0; i < taskDuration; i++){
                Thread.sleep(100);
                System.out.printf("Я %s. Всем привет! \n", Thread.currentThread().getName());
                counter++;
            }
        } catch (InterruptedException ignored) {
        }
        finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }

        return counter;
    }
}
