package com.company.MultiThreading;

public class terruptedThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("main thread end.");
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        // create hell thread, catch interruptedException, assign hello interrupt
        Thread hello = new HelloThread();
        hello.start();
        try{
            hello.join(); // wait helloThread end
        } catch(InterruptedException e){
            System.out.println("MyThread interrupted!");
        }
        hello.interrupt(); // if miss, hello will keep running
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()){
            n++;
            System.out.println(n + " hello!");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                System.out.println("HelloThread InterruptedException.");
                break;
            }
        }
    }
}
