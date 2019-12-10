package com.miguelub;

import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 2
 version: 1.0
 */
/*
Feu un programa que llegeix dos nombres enters (dividend i divisor) i escriu
els termes de la divisió: dividend = divisor * quocient + residu.
Per exemple, si llegeix 41 i 2, escriu “41 = 20 * 2 + 1”
 */
/*
    Tabla de test
    Entrada |Salida
    41 y 2  |“41 = 20 * 2 + 1”
    35 y 7  |"35=7*5"
 */
public class Division {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dividendo,divisor;
        System.out.print("Introduzca el dividendo: ");
        dividendo=input.nextInt();
        System.out.print("Introduzca el divisor:");
        divisor=input.nextInt();
        if(dividendo%divisor==0){
            System.out.println(dividendo+"="+(dividendo/divisor)+"*"+divisor);
        }else {
            System.out.println(dividendo + "=" + (dividendo / divisor) + "*" + divisor + "+" + (dividendo % divisor));
        }
    }
}
