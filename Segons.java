package com.miguelub;

import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 2
 version: 1.0
 */
/*
Feu un programa que converteix una quantitat donada de segons en dies, hores, minuts
i segons. Per exemple, si l’usuari introdueix 89999 segons, ha de sortir el missatge
"90000 segons son: 1d 1h 0m 0s", amb l’entrada 45 segons, ha de sortir el missatge
“0d 0h 0m 45s”.
 */
/*
    Tabla de test
    Entrada |Salida
 */
public class Segons {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int diaSeg=86400 ,horaSeg=3600, minSeg=60;
        int diaCount=0, horaCount=0, minCount=0;
        int userSeg;
        System.out.print("Introduzca la cantidad de segundos:");
        userSeg=input.nextInt();
        while(userSeg>=60){
            if(userSeg>diaSeg){
                userSeg-=diaSeg;
                diaCount++;
            }else if(userSeg>=horaSeg){
                userSeg-=horaSeg;
                horaCount++;
            }else if(userSeg>=minSeg){
                userSeg-=minSeg;
                minCount++;
            }
        }
        System.out.println("Los segundos son convertidos en;");
        System.out.println("Dias:"+diaCount);
        System.out.println("Horas:"+horaCount);
        System.out.println("Minutos:"+minCount);
        System.out.println("Segundos:"+userSeg);
    }
}
