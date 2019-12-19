package com.miguelub;

import java.util.Scanner;

public class GetMascotes {
    /*Caldrà també crear una classe, GestMascotes, on està el main(). S’ha de
demanar a l'usuari un enter n i tot seguit les dades de n mascotes. A l’acabar, el
programa mostrarà totes les dades de les mascotes que tenen un identificador de
botiga senar. Un exemple de sortida:*/


}

/*Cal crear una classe Mascota que permeti representar les següents dades de les
mascotes: nom (String), any de naixement (int) i l'identificador de botiga (int). L’any
de naixement no pot ser inferior a l’any 2.000 ni superior a 2020. El nombre
d’identificació de la botiga no pot ser inferior a 1. */
class Mascota{
    String nombre;
    int nacimiento;
    int shopId;
    String species;
    public  Mascota(String nombre,int nacimiento,int shopId,String species){
        Scanner sc=new Scanner(System.in);
        while (nacimiento<2000 && nacimiento>2020){
            System.out.println("Error el año de nacimiento de la mascota debe estar entre 2000 y 2020 ");
            System.out.println("Vuelva a introducirlos");
            nacimiento=sc.nextInt();
        }
        while(shopId<1){
            System.out.println("Error la id de la tienda no puede ser menor  1");
            System.out.println("Vuelva a introducirla");
            shopId=sc.nextInt();
        }
        this.nombre=nombre;
        this.nacimiento=nacimiento;
        this.shopId=shopId;
        this.species=species;

    }
}

/*A més a més, s’ha de crear una classe TaulaMascotes que permeti guardar en un
array totes les mascotes. Aquesta classe tindrà les següents funcions per a la gestió de
l’array de mascotes.
• TaulaMascotes(int m): permet inicialitzar la taula de mascotes
• void add(Mascota masc): si la Mascota masc compleix els requisits
de l’enunciat, l’afegirà a la taula*/

class TaulaMascotes{
    Mascota[] tablaMascotas;
    int totalMascotas;
    public TaulaMascotes(int n){
        this.tablaMascotas=new Mascota[n];
        totalMascotas=0;
    }
    void add(Mascota masc){
        tablaMascotas[totalMascotas]=masc;
        totalMascotas++;

    }
}
