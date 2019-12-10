package com.miguelub;

import java.util.Scanner;
/*
 author: Miguel Huayllas
 data: oct 8
 version: 1.0
 */
/*
Feu un programa que llegeix un nombre enter n i escriu el taulell d’escacs de mida n
x n
 */
public class Escacs {
    public static void main(String[] args) {
        char[][] tablero;
        Scanner input=new Scanner (System.in);
        int numero;

        System.out.println("Programa que dado un número entero devolvera un tablero de ajedrez n*n");
        System.out.print("Introducir el número: ");

        numero=input.nextInt();
        tablero=new char[numero][numero];
/*
Este problema lo pense en matriz y me di cuenta que las casillas "negras" cumplen cierto criterio
Aplicando ese criterio pinto negro donde se cumple y blanco donde no
*/
        for(int i=0;i<tablero.length;i++){

            for(int j=0;j<tablero[i].length;j++){

                if((i+j)%2==0){
                    System.out.print("#");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println(" ");    //Esta linea hara de salto de linea al final de cada fila
        }
    }
}
