package usage.advanced.future;

import cn.hutool.core.lang.Assert;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MultiThread {

    /**
     * 初始化CompletableFuture两种方法：
     * 1. new
     * 2. 静态工厂方法：runAsync, supplyAsync
     */
    public void init() {
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            return "supplyAsync()" + Thread.currentThread().getName();
        });
        try {
            System.out.println(stringCompletableFuture1.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void chainCaller() {
        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "hello!")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s +
                        "world!"));
        try {
            Assert.equals("hello!world!", future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    public void allof() {
        Random random = new Random();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("future1 done");
            }
            return "future1 returned";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("future2 done");
            }
            return "future2 returned";
        });

        CompletableFuture.allOf(future1, future2).join();
        try {
            CompletableFuture.allOf(future1, future2).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("all futures done...");
    }

    public static void main(String[] args) {
        new MultiThread().allof();
    }
}
