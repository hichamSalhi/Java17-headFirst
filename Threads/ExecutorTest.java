package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        
        // Create a Runnable job and execute it using an ExecutorService
        // Runnable job = new MyRunnable(); i m replacing this line because Runnable is a functionnal interface

        // Executors contain various factory methods for different types of executor services
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() +
                               ": top of the stack");
            Thread.dumpStack();
        });

        System.out.println(Thread.currentThread().getName() +
                       ": back in main");
        Thread.dumpStack();

        // If you don´t shutdown the executor, the program will not end (it´s waiting for new tasks like if we were in a server or a loop)
        executor.shutdown();
    }
}
