package com.miguelub;

public class Bucle{

    public static void main (String [] args){

        int a = 1, b = 2;

        metodeExemple(a);


        metodeExemple(b);

    }

    static void metodeExemple(int x){

        int i = 0;

        while (i < 10) {

            if ((i + x) % 2 == 0)

                System.out.print(i);

            i++;

        }

    }

}
