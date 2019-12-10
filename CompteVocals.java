package com.miguelub;

import java.util.Scanner;
/*
 author: Miguel Huayllas
 data: oct 15
 version: 1.0
 */
/*
 Feu un programa que llegeix un String i compta el nombre de vocals que hi ha en
total. Per exemple, “Avui fa molta calor.” dona el missatge “La frase té 8 vocals”.
Utilitza el mètode CharAt() per a resoldre’l.
 */
/*
    Tabla de test
    Entrada |Salida
    hola hombre |Número de vocales: 4
 */
public class CompteVocals {
    public static void main(String[] args) {
        String fraseUser;
        Scanner input = new Scanner(System.in);
        int numVocales = 0;

        System.out.println("Programa para contar el numero de vocales que existe en una frase");
        System.out.print("Por favor introduzca la frase:");

        fraseUser = input.nextLine();
        fraseUser = fraseUser.toLowerCase();      //Para simplificar el problema hago la frase a minuscula para que solo lo compare con las vocales en minuscula

        for (int i = 0; i < fraseUser.length(); i++) {
            if (fraseUser.charAt(i) == 'a' || fraseUser.charAt(i) == 'e' || fraseUser.charAt(i) == 'i' || fraseUser.charAt(i) == 'o' || fraseUser.charAt(i) == 'u')
                numVocales++;
        }
        System.out.print("Número de vocales: " + numVocales);
    }
}
