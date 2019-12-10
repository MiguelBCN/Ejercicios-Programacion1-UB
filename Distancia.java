package com.miguelub;

import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 3
 version: 1.0
 */
/*
Feu un programa que donats dos punts del pla amb les seves coordenades calcula la
distància euclidiana entre ells. Per més informació, podeu consultar a:
https://ca.wikipedia.org/wiki/Distància_euclidiana
 */
/*
    Tabla de test
    Entrada |Salida
    1,2,3,4 |2.00
 */
public class Distancia {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int punto1X, punto1y,punto2x,punto2y;
        System.out.println("Por favor introduzca los 2 puntos que sea guardar");
        System.out.print("Punto1 x:");
        punto1X=input.nextInt();
        System.out.print("Punto1 y:");
        punto1y=input.nextInt();
        System.out.print("Punto2 x:");
        punto2x=input.nextInt();
        System.out.print("Punto2 y:");
        punto2y=input.nextInt();
//Una vez obtenidos los puntos uso Math.sqrt() y aplico la formula euclidea para calcular la distancia
        System.out.println("La distancia euclidea entre los dos puntos es : "+Math.sqrt((punto2x-punto1X)+(punto2y-punto1y)));
    }
}
