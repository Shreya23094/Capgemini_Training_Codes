package com.dk;

//The start () function in thread will allow the methods to be run in the background
//So that we can work two things at the same time
//b= d;

class ChildThread extends Thread{
    ChildThread(){
        super();
    }
    ChildThread(ThreadGroup group){

        super(group, "dummy");
    }
    public void run(){
        for (int i = 0; i<=100; i++){
            System.out.println("Child 1 : "+i);
        }
    }
}

//to perform multi-threading we can implement Runnable interface which got only one method called run()
class ChildThread2 implements Runnable{
    public void run(){
        for (int i = 0; i<=100; i++){
            System.out.println("Child 2 : "+i);
        }
    }
}

//.class file in java
//java interpreter will run this class, then jvm will create new thread and call main in this thread
public class ThreadingBasic {
    public static void main(String[] args) {
        // Thread[main,5,main]
        //main is the type of thread being used (name), 5 is the priority of the thread, main is the place where thread is used
        Thread thread = Thread.currentThread();
        System.out.println("MAIN THREAD: "+thread);
        ChildThread t = new ChildThread();
        t.setName("childThread");
        t.setPriority(1);
        t.start();
        ChildThread2 obj = new ChildThread2();
        Thread t2 = new Thread(obj);
        t2.start();
        t2.setName("childThread2");
        t2.setPriority(10);
        for (int i = 0; i<=100; i++){
            System.out.println("main : "+i);
        }

//        Thread t4 = new ChildThread(group);
        //ChildThread t5 = new Thread(); -----wrong

        Runnable obj1 = () -> {
            for(int i = 0; i < 100; i++){
                System.out.println("runnable "+i);
            }
        };
        new Thread(obj1).start();
    }
}