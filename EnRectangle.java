package com.miguelub;

import java.util.Scanner;

/*
 author: Miguel Huayllas
 data: oct 3
 version: 1.0
 */
/*
Un rectangle que té els costats paral·lels als eixos està especificat per les coordenades
dels vèrtexs de baix a l’esquerra (x1, y1) i de dalt a la dreta (x2, y2). Feu un programa
que donades aquestes coordenades i les coordenades d’un punt (x, y), indica si aquest
punt es troba a dins o a fora del rectangle.
 */

public class EnRectangle {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int pBaj, pIzq, pAlto, pDer;        //Puntos de 2 esquinas del rectangulo ingresados por el usuario
        int coordX,coordY;                  //Punto x,y que ingresa el usuario para saber si esta dentro o no del rectangulo
        int areaRect;                       //Area del rectangulo
        int areaPrueba;                     //Area formada con una esq  uina del rectangulo y la coordendda del usuario

        System.out.println("Escriba las cordenadas de su rectangulo");
        System.out.println("Punto bajo y derecho:");
        pBaj=input.nextInt();
        pDer=input.nextInt();
        System.out.println("Punto alto y izquierdo");
        pAlto=input.nextInt();
        pIzq=input.nextInt();
        System.out.printf("Usted a introducido los puntos (%s,%s) (%s,%s)",pBaj,pDer,pAlto,pIzq);

        System.out.println("Introduzca las coordenadas del punto a comprobar:");
        System.out.print("Coordenada x");
        coordX=input.nextInt();
        System.out.print("Coordenada y");
        coordY=input.nextInt();

        /*Calculamos el Area del rectangulo aqui y definimos
        Si cogiendo una de las esquinas del rectangulo y el punto que el usuario quiere comprobar si esta dentro o no del rectangulo
        Definimos que esta dentro si el Area formada con este punto a comprobar es 0<Area formada con la nueva coordenda<Area del rectangulo*/
        areaRect=Math.abs(pAlto-pBaj)*Math.abs(pIzq-pDer);
        areaPrueba=Math.abs(coordY-pBaj)*Math.abs(coordX-pDer);
        if(0<areaPrueba && areaPrueba<areaRect){
            System.out.println("La coordenada esta dentro del rectangulo");
        }else{
            System.out.println("La coordenada no esta dentro del rectangulo");
        }
    }
}
