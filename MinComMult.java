package com.miguelub;
//ARREGLAR
public class MinComMult {
    public static void main(String[] args) {
        int num1=12,num2=8;
        for (int i=num2;(!(num1%i==0 )&& (num2%i==0));i++){
            System.out.println(i);
        }
    }
}
