package com.miguelub;

import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 2
 version: 1.0
 */
/*
Feu un programa que donat un nombre enter escriu si és un dígit o no. Per exemple,
si l’usuari introdueix 234 ha de sortir el missatge “No es un dígit”, si l’usuari
introdueix 4, ha de sortir el missatge “Es un dígit”.
*/
/*
Tabla de Test
Entrda  | Salida
4       |"Es un digito"
12442   |"No es un digito"
*/
public class Digit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inNumber;
        System.out.print("Por favor introduzca un número:");
        inNumber=input.nextInt();
        String msg = inNumber>0 && inNumber<9  ?
                "El numero intorducido es un digito" :
                "El numero introducido no es un digito";
        System.out.println(msg);
    }
}
