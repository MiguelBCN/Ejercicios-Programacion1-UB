import java.util.Scanner;

/*
*5.	Creeu un programa que al iniciar-se crea un array amb els dies de la setmana ("Dilluns", "Dimarts", "Dimecres", etc..).
* A continuació es demanarà per consola un número del 1 al 7 i es mostrarà el dia que correspon a aquell número (Exemple: Num: 3 -> "Dimecres"). (DiesSetmana.java)*/
public class DiesSetmana {
    public static void main(String[] args) {
        String[] semana={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        int numUser;
        Scanner sc=new Scanner(System.in);
        System.out.println("Por favor intorduzca un numero entre 1-7:");
        numUser=sc.nextInt();
        System.out.println(semana[numUser-1]);

    }
}
