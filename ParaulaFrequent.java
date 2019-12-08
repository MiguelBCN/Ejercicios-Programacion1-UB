import java.util.Scanner;

/*7.	Feu un programa que donats un nombre natural n i una seqüència de n paraules en minúscules, indiqui quina és la paraula més freqüent. (ParaulaFrequent.java)*/
public class ParaulaFrequent {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int repeteciones,posicionmax=0,numPalabraRepe,marcador=0;
        String frase;
        String[] fraseArray;

        System.out.println("Por favor iuntroduzca el numero de palabras que introducira");
        repeteciones=sc.nextInt();
        fraseArray=new String[repeteciones];

        System.out.println("Ahora introduzca su frase");
        for (int i = 0; i <repeteciones ; i++) {
            frase=sc.next();
            fraseArray[i]=frase.toLowerCase();
            System.out.print(fraseArray[i]+" ");

        }

        for (int i = 0; i <repeteciones ; i++) {
            numPalabraRepe=0;
            for (int j = 0; j <repeteciones ; j++) {

                if(fraseArray[i].equals(fraseArray[j])){
                    numPalabraRepe++;
                }

            }
            if(numPalabraRepe>marcador){
                posicionmax=i;
                marcador=numPalabraRepe;
            }

        }
        System.out.println();
        System.out.println("la palabra mas repetida es ("+fraseArray[posicionmax]+") con "+marcador+" repeticiones");



    }
}
