import java.util.Scanner;

public class Mitjana {
    public static void main(String[] args) {
        int mediaNivel=0,numeroUser,numerosPares=0;
        double mediaTotal=0;
        Scanner sc =new Scanner(System.in);
        do{
            System.out.println("Porfavor introduzca su numero , el programa cerrara cuando se introduzca un 0");
            numeroUser=sc.nextInt();
            if(numeroUser%2==0 && numeroUser!=0){
                numerosPares+=numeroUser;
                mediaNivel++;
                mediaTotal=numerosPares/(double)mediaNivel;
            }
            System.out.println("Acumulacion: "+numerosPares+" media: "+mediaNivel);
            System.out.println("La media actual de los numeros es: "+mediaTotal);

        }while(numeroUser!=0);
    }
}
