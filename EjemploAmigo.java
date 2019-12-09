public class EjemploAmigo {
    public static void main(String[] args) {
        int[] lolk=new int[7];
        System.out.println(lolk.length);
        for (int i = 0; i <lolk.length ; i++) {
            lolk[i]=i;
        }

        //Borrar el numero 3
        int pivote;
        boolean encontrado=false;
        mostrar(lolk);
        for (int i = 0; i <lolk.length && !false ; i++) {
            if(lolk[i]==3){
                encontrado=true;
                for (int j = i+1; j < lolk.length; j++,i++) {
                    lolk[i]=lolk[j];

                }
                lolk[i]=0;
            }

        }
        mostrar(lolk);

    }
    static void mostrar(int[] lista){
        System.out.println("La lista es");
        for (int i = 0; i <lista.length ; i++) {
            System.out.print(lista[i]);
        }
        System.out.println();
    }
}
