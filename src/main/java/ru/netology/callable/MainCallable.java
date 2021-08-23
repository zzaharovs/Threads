package ru.netology.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        final ExecutorService threadPool = Executors.newFixedThreadPool(4);


        invokeAllDemonstration(threadPool);

        System.out.println("========================================================================================");

        invokeAnyDemonstration(threadPool);

        threadPool.shutdown();

    }

    public static void invokeAnyDemonstration (ExecutorService threadPool) throws InterruptedException,
            ExecutionException {

        List<MyThreadCallable> taskListAny = new ArrayList<>();
        taskListAny.add(new MyThreadCallable());
        taskListAny.add(new MyThreadCallable());
        taskListAny.add(new MyThreadCallable());
        taskListAny.add(new MyThreadCallable());

        System.out.printf("Задание завершено. Самая быстрая задача вывела фразу %d раз\n",
                threadPool.invokeAny(taskListAny));

    }

    public static void invokeAllDemonstration (ExecutorService threadPool) throws InterruptedException,
            ExecutionException {

        List<MyThreadCallable> taskListAll = new ArrayList<>();
        taskListAll.add(new MyThreadCallable());
        taskListAll.add(new MyThreadCallable());
        taskListAll.add(new MyThreadCallable());
        taskListAll.add(new MyThreadCallable());


        final List<Future<Integer>> tasksAll = threadPool.invokeAll(taskListAll);

        for (Future<Integer> task : tasksAll) {

            System.out.printf("Задача завершена. Фраза выведена %d раз\n", task.get());

        }

    }



}
