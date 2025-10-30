package Threads;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println(Thread.currentThread().getName() + 
                       ": top of the stack");
        Thread.dumpStack();
    }
    
}
