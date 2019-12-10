package com.miguelub;

import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 2
 version: 1.0
 */
/*
        Feu un programa que donada l’edat d’una persona el 31 de desembre de 2019 calcula
        el seu any de naixement i en quin any tindrà el doble de l’edat que té el 31 desembre
        de 2019. Per exemple, si l’usuari introdueix l’edat 18, el programa donarà com sortida
        “Vas néixer l’any 2001. A l'any 2037 tindras 36 anys”
 */
/*
    Tabla de test
    Entrada |Salida
    16      |"Naciste el 2013 tendras 26 en el año 2035"
 */
public class Edat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int edadUser;
        int añoComp=2019;
        System.out.print("Introduce tu edad:");
        edadUser=input.nextInt();
        System.out.println("Tu naciste el año "+(añoComp-edadUser)+" y tendras el doble de tu edad ("+edadUser*2+") el proximo 31 de diciembre de "+(añoComp+(edadUser*2)));
    }

}
