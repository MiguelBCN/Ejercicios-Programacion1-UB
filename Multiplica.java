package com.miguelub;

import java.util.Scanner;
/*
 author: Miguel Huayllas
 data: oct 10
 version: 1.0
 */
//Practica en clase de problema de programacion
public class Multiplica {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num1 = (int)(Math.random() * 100);
        int num2 = (int)(Math.random() * 100);
        int numIntentos=1; //Max 10
        int numUser=(num1*num2)+1;

        System.out.println("Los numeros aleratorios creado son");
        System.out.println(num1+" "+num2);

        while (numUser != (num1 * num2) && numIntentos <= 10) {
            System.out.print("Escriba el numero: ");
            numUser = input.nextInt();

            if (numUser != (num1 * num2)) { //Ayuda a comprobar que si el numero es igual al resultado
                if (numIntentos == 10) {    //Ayuda a limitar el numero  de intentos
                    System.out.println("Numero de intentos superado");
                } else {
                    System.out.println("Numero equivocado por favor repita.");
                    if(numUser>(num1*num2)) {//Ayuda a controlar si el numero es cercca o lejos del numero acertado
                        System.out.println("Te pasaste");
                    }else {
                        System.out.println("Te falta");
                    }
                }
                numIntentos++;
            } else {
                System.out.println("Felicidades acerto el numero");
            }


        }
    }
}
