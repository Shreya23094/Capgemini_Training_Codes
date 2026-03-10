package com.dk;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Writer extends Thread{
    Printer printer;
    String msg;
    Writer(Printer printer, String msg){
        super();
        this.printer = printer;
        this.msg = msg;
    }
    public void run(){
        try{
            synchronized (printer){
                printer.print(msg);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Printer{
    public void print(String msg) throws InterruptedException{
        System.out.println("[");
        Thread.sleep(2000);
        System.out.println(msg);
        System.out.println("]");
    }
}
public class SyncDemo{
    public static void main(String[] args) {
        Printer printer = new Printer();
        Writer w1 = new Writer(printer, "Java");
        Writer w2 = new Writer(printer, "Threads");
        w1.start();
        w2.start();
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.submit(() -> {
            for(int i = 1; i <= 40; i++){
                System.out.println("thread : "+i);
            }
        });
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        Callable<Integer> call =() ->{
         Thread.sleep(4000);
         return new Random().nextInt();
        };
        Future<Integer> future = singleThread.submit(call);
    }
}
