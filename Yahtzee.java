/*
 author: Miguel Huayllas
 data: nov 28
 version: 1.0
 */
/*13.	Feu un programa per a jugar a una versió simple del Yahtzee. El programa ha de simular la tirada de cinc daus i imprimeix
"Yahtzee" si els cinc daus són iguals; en cas contrari, s'hauria d'imprimir "Torna a intentar-ho". Teniu en compte que la tirada de un dau dona un nombre entre 1 i 6. (Yahtzee.java)

Implementa els següents mètodes:
•	static void tiraDados(int [] daus)

Aquest mètode omple l’array daus amb els valors dels daus d’una tirada.

•	static boolean esYahtzee(int [] daus)

Aquest mètode retorna true si s’ha aconseguit yatzee amb els valors del paràmetre daus, false en cas contrari.
*/


public class Yahtzee {
    public static void main(String[] args) {
        int[]dados=new int[5];  //Esta variable guardara los dados
        boolean yathzee;        //Esta variable guardara un booelan si hay  o no yathzee
        System.out.println("Comenzando el juego.....");
        //Aqui ejecuto un bucle que se ira repetiendo continuamente hasta que se logre un yathzee
        //Rong lo que hace el do es igual a un while solo con una pequeña diferencia que hace que se ejecute al menos una vez ignorando la condicion del while

        do{
            //Genero los dados
            System.out.println("Tirando dados....");
            dados=tirarDados(dados);

            //Se los muestro al usuario haciendo un print del array
            System.out.println("Los numeros :");
            for (int i = 0; i <dados.length ; i++) {
                System.out.print(dados[i]+" ");
            }
            System.out.println();

            //Finalmente compruebo si con esos numeros se logra o no un yathzee
            yathzee=resulDados(dados);
            if(!yathzee)
                System.out.println("No son Yathzee");
            else
                System.out.println("Es Yathzee");
        }while(!yathzee);


    }
    static int[] tirarDados(int [] dados){
        for (int i = 0; i <dados.length ; i++) {
            dados[i]=(int)(Math.random()*6+1);
        }
        return dados;

    }
    static boolean resulDados(int[] dados){
        boolean esYathzee=true;
        int comodin=dados[0];
        for (int i = 0; i <dados.length ; i++) {
            if(comodin!=dados[i])
                esYathzee=false;
        }
        return esYathzee;
    }
}
