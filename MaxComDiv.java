package com.miguelub;

public class MaxComDiv {
    public static void main(String[] args) {
        int num1=49 ,num2=22,piv;
        if(num1>num2){
            piv=num1;
            num1=num2;
            num2=piv;
        }
        for (int i=0;i<num1;i++){
            if(num2%(num1-i)==0 && num1%(num1-i)==0){
                System.out.println(num1-i);
                break;
            }
        }
    }
}
