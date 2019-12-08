import java.util.Scanner;

public class ParaulaFrequent2 {
    public static void main(String[] args) {
        Scanner scInt=new Scanner(System.in);
        Scanner scString =new Scanner(System.in);
        int repeticiones;
        String frase;

        System.out.println("Ahora introduzca el numero de palabras que usara");
        repeticiones=scInt.nextInt();

        System.out.println("Ahora introduzca la frase");
        frase=scString.nextLine();

        System.out.println(frase);
    }
}
