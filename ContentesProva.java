package com.miguelub;

import java.util.Scanner;

public class ContentesProva {
    /*
 author: Miguel Huayllas
 data: oct 29
 version: 1.0
 */

    /*  En aquesta modificació una vocal està contenta només si té al seu voltant (tant a l'esquerra com a la dreta) la mateixa vocal.
        Donada per teclat una frase, s’ha de mostrar, per cada vocal, el nombre de vegades que la vocal està contenta i el nombre de vegades que no està contenta.
        A més a més, s’han de mostrar les vocals contentes en majúscula. Vegeu exemple d’execució més a baix. La sortida ha de tenir el mateix format
        que s’indica a continuació.
    */
    public static void main(String[] args) {
        //VARIABLES
        Scanner sc = new Scanner(System.in);
        String fraseUser;
        String[] fraseUserArray, vocalesArray;
        String vocales = "aeiou";

        //SOLICITUD DE INFORMACION AL USUARIO
        System.out.println("Introduzca la frase:");
        fraseUser = sc.nextLine();
        fraseUserArray = fraseUser.split("");
        vocalesArray = vocales.split("");
        System.out.println("Comenzando el analisis.....");
        System.out.println("");

        //EJECUCION DEL PROGRAMA
        //
        for (int j = 0; j < vocales.length(); j++) {
            int vocalesCont = 0, vocalesNoCont = 0;//Es necesario que cada siguiente vocal empecemos desde cero para que no se acumule
            for (int i = 1; i < (fraseUser.length() - 1); i++) {
                if (fraseUserArray[i].equals(vocalesArray[j]))
                {
                    //Comprobamos que por izquierda y derecha sean la misma vocal
                    if ((fraseUserArray[i + 1].equals(vocalesArray[j])) && (fraseUserArray[i - 1].equals(vocalesArray[j]))) {
                        fraseUserArray[i]=vocalesArray[j].toUpperCase();
                        vocalesCont++;
                    } else {
                        vocalesNoCont++;
                    }
                }
            }


            //Aqui empieza los datos que se le muestra al usuario
            for (int k = 0; k < fraseUserArray.length; k++) {
                System.out.print(fraseUserArray[k]);
            }
            System.out.println("");
            System.out.println(vocalesCont + " " + vocalesArray[j] + " estan contentas");
            System.out.println(vocalesNoCont + " " + vocalesArray[j] + " no estan contentas");
        }
    }

}
