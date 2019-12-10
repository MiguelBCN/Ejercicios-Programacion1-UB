package com.miguelub;

import java.util.Random;
import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 15
 version: 1.0
 */
/*
Feu un programa per a jugar el joc del Nim. Dos jugadors col·loquen a un tauler un
nombre de fitxes major o igual a 20 i menor estricte a 30 (aquest nombre es genera de
forma aleatòria). Un jugador és l’ordinador, l’altre serà un jugador humà. Un nombre
també aleatori indicarà quin jugador comença a jugar. Cada jugador en el seu torn
retira una o dues fitxes. L’ordinador genera un nombre aleatori entre 1 i 2 per a retirar
fitxes. El tauler s’ha d’anar actualitzant en cada torn. Guanya el jugador que
aconsegueix retirar l’última fitxa.
 */
/*
    Tabla de test
    Entrada |Salida

 */
/*Para que funcione pensamos que en la siguientes variables
* juegoActivo
* turnoJugador
* ganador
* numero de fichas
*
* */
public class Nim {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean turnoJugador = new Random().nextBoolean();//Comenzamos dando un valor booleano aleratorio
        boolean juegoActivo = true;
        int numFichas;
        int tableroNim = (int) (Math.random() * 8) + 23;//Formula para generar un numeroentre 23 y 30
        System.out.println("Comenzando juego Nim");
        System.out.println("Escogiendo quien empieza primero.....");

        //Con este if elegimos quien empieza primero
        if (turnoJugador)
            System.out.println("Empieza la maquina");
        else
            System.out.println("Empieza el jugador");

        System.out.printf("Número de fichas restantes:%s\n", tableroNim);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");

        while (juegoActivo) {
            //Añadimos informacion extra para que lo vea el usuario
            if (turnoJugador)
                System.out.println("-Turno del jugador");
            else
                System.out.println("-Turno de la máquina");
            System.out.printf("Número de fichas restantes:%s\n", tableroNim);

            //Aqui empieza el turno el jugador
            if (turnoJugador) {
                System.out.println("Escoja el numero de fichas que desea sacar:");
                numFichas = input.nextInt();
                //Una pequeña medida de seguridad para que el usuario juegue limpio
                while (numFichas < 0 || numFichas > 2) {
                    System.out.println("Numero de fichas incorrecto , valores aceptados entre[1,3]");
                    System.out.print("Introduzc de nuevo: ");
                    numFichas = input.nextInt();
                }
                tableroNim -= numFichas;
                if (tableroNim == 0) {
                    juegoActivo = false;
                    System.out.println("Ganaste jugador");
                }

                //Aqui empieza el turno de la maquina
            } else {
                //el numFichas que pondra la maquina dependera de tableroNim especificamente veremos cuando tableroNim<6
                numFichas = (int) (Math.random() * 2) + 1;
                while (numFichas > tableroNim)
                    numFichas = (int) (Math.random() * 2) + 1;
                System.out.printf("La maquina saca %s fichas\n", numFichas);
                tableroNim -= numFichas;
                if (tableroNim == 0) {
                    juegoActivo = false;
                    System.out.println("Gana la máquina");
                }

            }
            //Al final de cada turno se cambia a quien le toca
            turnoJugador = !turnoJugador;
        }
    }
}
