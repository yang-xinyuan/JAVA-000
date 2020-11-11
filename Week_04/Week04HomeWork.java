package com.wendao.controller;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class Week04HomeWork {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        long start=System.currentTimeMillis();
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future1 = futureExecutors(executor);
        FutureTask<Integer> future2 = futureTask();
        FutureTask<Integer> future3 = futureTaskExecutor(executor);
        CompletableFuture<Integer> future4 = completableFuture();
        CompletableFuture<Integer> future5 = completableFutureExecutor(executor);
        CompletableFuture<Integer> future6 = completableFutureThread();
        CompletableFuture<Integer> future7 = completableFutureSupplier(executor);
        System.out.println("执行前面步骤使用时间："+ (System.currentTimeMillis()-start) + " ms");
        executor.shutdown();

        System.out.println("1：" + future1.get());
        System.out.println("2：" + future2.get());
        System.out.println("3：" + future3.get());
        System.out.println("4：" + future4.get());
        System.out.println("5：" + future5.get());
        System.out.println("6：" + future6.get());
        System.out.println("7：" + future7.get());
        System.out.println("完成使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    /**
     * 1. 通过线程池，future
     * @param executorService
     * @return
     */
    public static Future futureExecutors(ExecutorService executorService){
        Future<Integer > future = executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        return future;
    }

    /**
     * 2. 单线程方式执行FutureTask
     * @return
     */
    public static FutureTask futureTask(){
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });
        new Thread(integerFutureTask).start();
        return integerFutureTask;
    }

    /**
     * 3. 线程池方式执行futureTask
     * @param executorService
     * @return
     */
    public static FutureTask futureTaskExecutor(ExecutorService executorService){
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3;
            }
        });
        executorService.submit(integerFutureTask);
        return integerFutureTask;
    }

    /**
     * 4 lambda执行 completableFuture
     * @return
     */
    public static  CompletableFuture completableFuture(){
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 4);
        return integerCompletableFuture;
    }

    /**
     * 5. lambda 线程池方式执行CompletableFuture
     * @param executorService
     * @return
     */
    public static CompletableFuture completableFutureExecutor(ExecutorService executorService){
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 5, executorService);
        return integerCompletableFuture;
    }

    /**
     * 6.单线程执行completableFuture
     * @return
     */
    public static CompletableFuture completableFutureThread(){
        CompletableFuture<Object> completableFuture = new CompletableFuture<>();
        new Thread(()->{
            completableFuture.complete(6);
        }).start();
        return completableFuture;
    }

    /**
     * 7 completableFutureSupplier
     * @param executorService
     * @return
     */
    public static CompletableFuture completableFutureSupplier(ExecutorService executorService){
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {

            @Override
            public Integer get() {
                return 7;
            }
        }, executorService);
        return integerCompletableFuture;
    }
}
