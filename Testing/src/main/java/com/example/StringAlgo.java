package com.example;

import java.util.Scanner;

public class StringAlgo{
    String shift2Chars(String str){
        StringBuilder sBuild =  new StringBuilder();
        if(str.length()<=2){
            return str;
        }
        for(int i = 2; i<str.length(); i++){
            sBuild.append(str.charAt(i));
        }
        sBuild.append(str.charAt(0));
        sBuild.append(str.charAt(1));
        return sBuild.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string : ");
        String str = sc.next();
        StringAlgo sa = new StringAlgo();
        String result = sa.shift2Chars(str);
        System.out.println("The result is : "+result);
    }
}