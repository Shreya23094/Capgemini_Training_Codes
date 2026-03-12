package com.gal.algo;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class MyCalc implements Calc {

    @Override
    public int add(int a, int b){
        return a + b;
    }

    @PostConstruct
    public void onInit(){
        System.out.println("Initialization method: DB connect, Websockets open, network connect");
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("On Destroy of object: close resources");
    }
}
