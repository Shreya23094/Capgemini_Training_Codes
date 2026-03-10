package com.dk;

import java.util.*;

class Downloader extends Thread{
    String image;
    Downloader(String image){
        this.image = image;
    }
    public void run(){
        System.out.println("Thread started");
        this.download(image);
    }
    public void download(String image){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Downloading : "+image);
    }
}

public class ImageDownloader {
    public static void main(String[] args) throws InterruptedException{
        List<Thread> list = new ArrayList<Thread>();
        String[] images = {"image1","image2","image3"};
        for(int i = 0; i<images.length; i++){
            Downloader loader = new Downloader(images[i]);
            list.add(loader);
            loader.start();
            //let it finish main
        }
        for(Thread t : list){
            t.join();
        }
    }
}