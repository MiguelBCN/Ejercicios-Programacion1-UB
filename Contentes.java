package com.miguelub;

import java.util.Scanner;
/*
 author: Miguel Huayllas
 data: oct 9
 version: 1.0
 */
/*
Feu un programa per a veure si cada caràcter ‘a’ d’una paraula llegida per teclat està
contenta. Una ‘a’ està contenta si té a la seva esquerra o a la seva dreta una altre ‘a’.
El programa ens diu si totes les ‘a’ estan contentes. Per exemple: si introduïm
“zdaaoa” el programa mostra el missatge “No totes les a estan contentes”, amb la
cadena “zdaa” el programa mostra “Totes les a estan contentes”
 */
/*
    Tabla de test
    Entrada |Salida
    holaa   | Todas las a estan contentas
    hola    |Todas las a no estan contentas
    aazd    |Todas las a estan contentas
    aazda   |Todas las a no estan contentas
 */
public class Contentes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fraseUser = " "; //Aqui almacenaremos la palabra que introduzca el usuario
        boolean todaAContenta = true;   //Esta variable se mantendra true hasta que encuentre una a no feliz
        String[] fraseUserArray;    //Para comprobar la frase introducida por el usuario necesitamos un array , por lo cual convertimos su mensaje en array
        String messageForUser;      //Mensaje que monstrara al usuario


        System.out.println("Escribe un programq ue diog asi las a estan contentas o no  , eto se determina si se ve a izquierda y derecha que tiene otras a , sera true solo si pasa para todas las a");
        System.out.println("Introducir frase:");
        fraseUser = input.nextLine();
        fraseUserArray = fraseUser.split("");


        for (int i = 0; i < fraseUser.length(); i++) {
                //Caso en el que la primera letra es a
            if (i == 0 && fraseUserArray[i].equals("a")) {
                if (!fraseUserArray[i + 1].equals("a")) {
                    todaAContenta = false;
                }
                //Caso en que la ultima letra es a
            } else if (i == fraseUserArray.length - 1 && fraseUserArray[fraseUserArray.length - 1].equals("a")) {
                if (!fraseUserArray[fraseUserArray.length - 2].equals("a")) {
                    todaAContenta = false;
                }
                //Caso en el cual existe una en cualquier otra situacion
            } else if (fraseUserArray[i].equals("a"))
                //Este if suele devolver siempre true si encuentra un por izquierda o derecha algo distinto a ,  por lo cual si queremos que funcione
                //Usamos un NOR que nos devolvera siempre false si existe un a por izquierda o derecha
                if (!(fraseUserArray[i + 1].equals("a") || fraseUserArray[i - 1].equals("a"))) {
                    {
                        todaAContenta = false;
                    }
                }
        }
        //Finalmente con un operador ternario escribimos en base a la variable todaAContenta el mensaje al usuario
        messageForUser = todaAContenta ? "Todas las a estan contentas" : "Todas las a no estan contentas";
        System.out.println(messageForUser);
    }
}
