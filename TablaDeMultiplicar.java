package com.miguelub;

import java.util.Scanner;

public class TablaDeMultiplicar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t,numEsp,numEst,j,k;
        System.out.println("Tamaño:");
        t=sc.nextInt();
        while(t%2==0){
            System.out.println("Tamaño:");
            t=sc.nextInt();
        }
        for(numEsp=t-1,numEst=1;numEsp>=0;numEsp-=2,numEst+=2){
            for(j=0;j<numEsp;j++){
                System.out.print(" ");
            }
            for(k=0;k<numEst;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (numEsp=2,numEst=t-2;numEst>=0;numEsp+=2,numEst-=2){
            for(j=0;j<numEsp;j++){
                System.out.print(" ");
            }
            for(k=0;k<numEst;k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
