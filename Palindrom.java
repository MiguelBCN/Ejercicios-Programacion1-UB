package com.miguelub;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        //Escribir un programa que diga si una palabra es un palindromo o no
        boolean palin;
        Scanner sc=new Scanner(System.in);
        String palabra;
        System.out.println("Por favor introduzca su palabra");
        palabra=sc.next();
        palin=esPalindromo(palabra);
        if(palin){
            System.out.println("Es palindromo");
        }else{
            System.out.println("No es palindromo");
        }
    }
    static boolean esPalindromo(String palabra){
        int longitud=palabra.length()-1;
        int longitud_mitad=(int)longitud/2;

        boolean palin=true;
        for (int i = 0; i <longitud_mitad ; i++) {
            if (palabra.charAt(i)!= palabra.charAt(longitud-i))
                palin=false;

        }
        return palin;
    }
}
