package com.company.MultiThreading;

public class Main {
    public static void main(String[] args) {
        Counter t1 = new Counter();
        Counter t2 = new Counter();
        new Thread(() -> t1.add(100)).start();
        new Thread(() -> t1.dec(100)).start();

        new Thread(() -> t2.add(100)).start();
        new Thread(() -> t2.dec(100)).start();
        System.out.println("t1.count = " + t1.get());
        System.out.println("t2.count = " + t2.get());
    }
}
class Counter{
    private int count = 0;
    public synchronized void add(int n){
        count += n;
    }
    public synchronized void dec(int n){
        count -= n;
    }
    public int get(){
        return count;
    }
}
