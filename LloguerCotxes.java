package com.miguelub;
import java.util.Scanner;

public class LloguerCotxes {
    /*

    A continuació feu una classe (LloguerCotxes) que permetra guardar un conjunt
de cotxes, i les opcions del menú seran:
*/
    public static void main(String[] args) {
        TaulaCotxe tablaCoche;
        Scanner sc =new Scanner(System.in);
        int opcion,id,dias;
        String marca,modelo,color;
        float precio;
        boolean salir=false;

        System.out.println("Comenzando el programa de alquiler de coches..");

        System.out.println("Escoja cuantos autos tendra almacenados(max:100)");
        opcion=sc.nextInt();
        tablaCoche=new TaulaCotxe(opcion);

        imprimirMenu();
        System.out.println("Por favor escoja la opcion:");
        opcion=sc.nextInt();

         while (!salir){
             switch (opcion){
                 case 1:
                     //Afegir cotxe: demanarà les dades del nou cotxe i l'afegirà al conjunt de cotxes.
                     System.out.println("Ha seleccionado la opcion añadir un coche");
                     System.out.println("Por favor ingrese los datos necesarios para añadir un coche:");
                     System.out.println("Marca:");
                     marca=sc.next();

                     System.out.println("Modelo:");
                     modelo=sc.next();

                     System.out.println("Color:");
                     color=sc.next();
                     System.out.println("Precio de alquiler por dia:");
                     precio=sc.nextFloat();
                     tablaCoche.afegir(marca,modelo,color,precio);


                     break;
                 case 2:
                     //Veure cotxes disponibles: mostrarà informació dels cotxes no llogats.
                     tablaCoche.veureDisponibles();
                     break;
                 case 3:
                     //Veure cotxes llogats: mostrarà informació dels cotxes llogats, mostrant per a cadascun d'ells els dies que està llogat.
                     tablaCoche.veureLlogats();
                     break;
                 case 4:
                     //Esborrar cotxe: mostrarà informació dels cotxes disponibles, amb el seu ID (els
                     //cotxes llogats no els podem eliminar). A continuació, donat l’ID, s'eliminarà el cotxe amb aquest identificador.
                     System.out.println("Ha seleccionado la opcion de borrar ");
                     System.out.println("Por favor ingrese la id del coche que desea borrar:");
                     System.out.println("id:");
                     id=sc.nextInt();
                     tablaCoche.esborrar(id);
                     break;
                 case 5:
                     //Llogar cotxe: mostrarà informació dels cotxes disponibles, cadascun amb el seu
                     //ID. A continuació es demanarà el ID del cotxe a llogar i el número de dies que es
                     //desitja llogar. El cotxe quedarà com a llogat des d'aquell moment.

                     System.out.println("Ha seleccionado alquilar un coche por favor ingre la id del coche y los dias que desea alquilarlo");
                     System.out.println("id:");
                     id=sc.nextInt();
                     System.out.println("Dias a alquilar:");
                     dias=sc.nextInt();
                     tablaCoche.llogar(id,dias);
                     break;
                 case 6:
                     //Lliurar cotxe: mostrarà els cotxes llogats, cadascun amb el seu ID. A continuació.
                     //Es demanarà el ID del cotxe a lliurar. El cotxe quedarà com a disponible des d'aquell moment
                     System.out.println("Ha seleccionado liberar  un coche por favor ingrese la id del coche");
                     System.out.println("id:");
                     id=sc.nextInt();
                     tablaCoche.lliurar(id);
                     break;
                 case 7:
                     //Veure preu de lloguer: mostrarà informació dels cotxes llogats, cadascun amb el
                     //seu ID. A continuació es demanarà el ID del cotxe a veure i es mostrarà el preu total del seu lloguer.
                     int alquilados=0;
                     for (int i = 0; i <tablaCoche.totalAutos ; i++) {
                         if(tablaCoche.coches[i].llogat){
                             alquilados++;
                             tablaCoche.veurePreu(i);}

                     }
                     if (alquilados==0)
                         System.out.println("No hay autos alquilados por el momento");

                     break;
                 default:
                     salir=true;
                     break;
             }
             imprimirMenu();
             System.out.println("Por favor escoja la opcion:");
             opcion=sc.nextInt();
         }


    }
    static void imprimirMenu(){
        System.out.println("---MENU---");
        System.out.println("1.-Añadir coche");
        System.out.println("2.-Ver coches disponibles");
        System.out.println("3.-Ver coches alquilados");
        System.out.println("4.-Borrar coche");
        System.out.println("5.-Alquilar coche");
        System.out.println("6.-Liberar coche");
        System.out.println("7.-Ver precio de alquiler");
    }
}

    class Cotxe {
        /*
        Definiu una classe Cotxe amb els següents atributs i els següents mètodes:
        Atributs
        • int iD;
        • String marca;
        • String model;
        • String color;
        • float preuPerDia;
        • boolean llogat;
        • int numDiesLloguer;
*/
        int iD;
        String marca;
        String model;
        String color;
        float preuPerDia;
        boolean llogat;
        int numDiesLloguer;

        public Cotxe(int iD, String marca, String model, String color, float preuPerDia, boolean llogat, int numDiesLloguer) {
            this.iD = iD;
            this.marca = marca;
            this.model = model;
            this.color = color;
            this.preuPerDia = preuPerDia;
            this.llogat = llogat;
            this.numDiesLloguer = numDiesLloguer;
        }

        boolean estaLlogat() {
            //veure si el cotxe està llogat.
            return this.llogat;
        }

        void llogar(int numDiesLloguer) {
            //llogar el cotxe el nombre de dies indicats al parèmetre numDiesLloguer.
            this.numDiesLloguer = numDiesLloguer;
        }

        float getPreuTotalLloguer() {
            //obtenir preu total del lloguer (multiplica el preu de lloguer pel número de dies que s'ha llogat el cotxe).
            return this.preuPerDia * this.numDiesLloguer;
        }


    }


    /*Per guardar el conjunt de cotxes, definiu la classe TaulaCotxe que emmagatzema
    un conjunt de cotxes (màxim seran 100). En aquesta classe tindreu els següents
    mètodes:*/
    class TaulaCotxe {
        //La variable maxAutos tendra un valor unico  y como max 100
        //La variable totalAutos empecera en 0 e ira aumentando en 1 cada vez que se agregue un auto

        Cotxe[] coches;
         int maxAutos;
        int totalAutos;

        public TaulaCotxe(int limit) {
            //TaulaCotxe(int limit), mètode constructor.
            Scanner sc=new Scanner(System.in);
            while(limit>100){
                System.out.printf("Error ha sobrepasado el  limite permitido (100) ,vuelva a introducirlo:%n");
                limit=sc.nextInt();

            }
            this.maxAutos=limit;
            this.coches = new Cotxe[maxAutos];
            this.maxAutos=limit;
            totalAutos=0;
        }


        void afegir(String marca, String model, String color, float preu) {
            //mètode per afegir un nou cotxe al conjunt de cotxes.
            coches[totalAutos]  = new Cotxe(totalAutos, marca, model, color, preu, false, 0);
            totalAutos++;
            System.out.printf("Se a añadido correctamente el auto con el id:%s ,marca:%s ,modelo:%s ,color:%s ,precio por dia:%s %n",totalAutos,marca,model,color,preu);
        }

        void veurePreu(int id) {
            //mètode per veure el preu total del lloguer del cotxe amb l’id indicat al paràmetre.

            System.out.printf("El coche con la id:%s tiene un precio de alquiler por dia de :%s %n",coches[id].iD,coches[id].preuPerDia);
        }

        void llogar(int id, int dies) {
            //mètode per llogar un cotxe amb l’id indicat al paràmetre, i un nombre de dies, dies.
            coches[id].llogat=true;
            coches[id].numDiesLloguer=dies;
            System.out.printf("El auto con la id: %s se ha alquilado correctamente por %s dias%n",id,dies);
        }

        void lliurar(int id) {
            //mètode per lliurar un cotxe a partir del seu id.
            coches[id].llogat=false;
            coches[id].numDiesLloguer=0;
            System.out.printf("El auto con la id: %s se ha libreado correctamente%n",id);
        }

        void esborrar(int id) {
            /*mètode per esborrar un cotxe del conjunt, amb id
        indicat al paràmetre. Quan s’esborra un cotxe de l’array, aquest array s’ha de
        quedar sense “buits”. Això vol dir que s’han de desplaçar tots els elements de
        l’array (que estaven a la dreta del cotxe a esborrar) per a ocupar l’espai que deixa
        aquest cotxe.*/
            System.out.printf("El auto con la id: %s se ha eliminado correctamente%n",id);
            for (int i = 0; i <totalAutos ; i++) {
                if(coches[i].iD==id){
                    for (int j = i+1; j <totalAutos ; j++,i++) {
                        coches[i]=coches[j];
                    }
                    coches[i]=null;
                }

            }
            this.totalAutos--;

        }

        void veureDisponibles() {
            //mètode per llistar els IDs de tots els cotxes que estiguin disponibles en el conjunt.
            int autosDisponibles=0;
            for (int i = 0; i <totalAutos ; i++) {
                if (!coches[i].llogat){
                    System.out.print(coches[i].iD+" ");
                    System.out.printf("El auto con la id:%s esta disponible para alquilar con un precio de %s euros por dia %n",coches[i].iD,coches[i].preuPerDia);
                    autosDisponibles++;
                }
            }
            if (autosDisponibles==0)
                System.out.println("No hay autos disponibles");
            System.out.println();

        }

        void veureLlogats() {
            int autosAlquildos=0;
            //mètode per llistat els IDs de tots els cotxes que estan llogats del conjunt de cotxes.
            for (int i = 0; i <totalAutos ; i++) {
                if (coches[i].llogat){
                    System.out.printf("El auto con la id:%s ya esta alquilado por %s dias %n",coches[i].iD,coches[i].numDiesLloguer);
                    autosAlquildos++;
                }
            }
            if (autosAlquildos==0)
                System.out.println("Actualmente no hay autos alquilados");
            System.out.println();
        }

    }




