package com.miguelub;

import java.util.Scanner;

public class Conjunts {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean mismosNumeros=true,endLista=false;
        int[] lista1,lista2;
        int maxLength,i=0,num;

        System.out.println("Este programa comparara dos lista de numeros y nos dira si ambas contienen los mismos numeros");
        System.out.println("Por favor introduzca el numero maximo de numeros que introducira:");
        maxLength=sc.nextInt();
        lista1=new int[maxLength+1];
        lista2=new int[maxLength+1];

        System.out.println("Ahora introduzca los numeros de la primera lista");

        do{
            System.out.println("Introduzca el numero:");
            num=sc.nextInt();
            lista1[i]=num;
            i++;

        }while(i<maxLength && num!=0);
        i=0;
        System.out.println("Ahora introduzca los numeros de la segunda lista");
        do{
            System.out.println("Introduzca el numero:");
            num=sc.nextInt();
            lista2[i]=num;
            i++;
        }while(i<maxLength && num!=0);

        for (int j = 0; j <lista1.length ; j++) {
            System.out.print(lista1[j]);

        }
        System.out.println();
        for (int j = 0; j <lista2.length ; j++) {
            System.out.print(lista2[j]);
        }




    }
}
