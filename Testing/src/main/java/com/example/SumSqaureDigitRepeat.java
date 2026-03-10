package com.example;

import java.util.HashSet;
import java.util.Set;

public class SumSqaureDigitRepeat {
    public int stepsToGetBackWithSumDigitSquare(int n){
        Set<Integer> set = new HashSet<>();
        int temp = n;
        int steps = 0;
        while(!set.contains(temp)){
            set.add(temp);
            int sum = 0;
            while(temp!=0){
                int rem = temp%10;
                sum += rem * rem;
                temp = temp/10;
            }
            temp = sum;
            steps++;
        }
        if(temp == n){return steps;}
        else{return -1;}
    }
}
