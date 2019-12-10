package com.miguelub;

import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 3
 version: 1.0
 */
/*
Feu un programa que calcula el màxim de tres nombres reals, usant com a molt dues
instruccions if.
 */
/*
    Tabla de test
    Entrada |Salida
    2,8,6   |8
 */
public class Maxof3 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int[] numeros=new int[3];
        int maxNumero;
        System.out.println("Por favor introduzca 3 numeros a comparar");
        for (int i=0;i<numeros.length;i++){
            numeros[i]=input.nextInt();
        }
        maxNumero=numeros[0];
        if(numeros[1]>=maxNumero ){
            maxNumero=numeros[1];
        }
        if(numeros[2]>=maxNumero ){
            maxNumero=numeros[2];
        }
        System.out.println("El numero maximo es: "+maxNumero);
    }

}
