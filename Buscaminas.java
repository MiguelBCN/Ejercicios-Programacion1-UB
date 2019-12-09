/*
 author: Miguel Huayllas
 data: dic 1
 version: 1.0
 */
/*
Joc del Buscamines:
Heu d'implementar el joc del buscamines on l'usuari entrarà un nombre enter per terminal
i aleshores el programa crearà un tauler nxn de tipus char amb n bombes col·locades aleatòriament.
L'usuari ha de, com a mínim, poder efectuar mitjançant un menu, les següents operacions durant una partida:
1. Fer una aposta d'on es troba una bomba. Per fer-ho, es demanarà per pantalla dos nombres enters, fila i columna.
2. Descobrir el contingut d'una cel·la on,
    Si seleccionem una cel·la amb una bomba, perderem la partida i finalitzarem el programa.
    Si no conté cap bomba, el programa calcularà quantes bombes hi ha en les 8 cel·les immediatament contigües (les 4 a en vertical i horitzontal, i les 4 en diagonal)
3. Imprimir per pantalla l'estat actual del joc.
    S'imprimirà un '?' si no sabem que hi ha en una cel·la.
    S'imprimirà una '*' si hem seleccionat aquella cel·la com a cel·la amb bomba.
    S'imprimirà un int de 0 a 8 si hem descobert aquella cel·la (i no conté cap bomba) indicant el nombre de bombes que té al seu costat.
4. Resoldre la partida. Això és, comprovar si hem col·locat les '*' sobre les cel·les amb bomba i no ens hem deixat cap.
    Si s'ha realitzat tot correctament apareixerà un missatge indicant que hem guanyat la partida.
    Si ens hem deixat alguna bomba sense marcar, apareixerà un missatge indicant que hem perdut la partida, i ens mostrarà on estaven les bombes.
    En ambdós casos, un cop realitzada aquesta opció, finalitzarem el programa correctament.
5. Sortir de la partida sense resoldre-la.
*/

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Buscaminas {
    enum MenuOption {
        BOMB, DISCOVER, PRINT, RESOLVE, EXIT;
    }

    public static void main(String[] args) {
        Scanner sc;
        int n, opt, resDiscover = 0;
        char[][] game;
        char[][] bombs;
        MenuOption option;

        sc = new Scanner(System.in);
        System.out.println("Board dimension (n): ");
        n = sc.nextInt();
        while (n <= 0) {
            System.out.println("Dimension cannot be negative or zero. Try again");
            System.out.println("Input for dimension n: ");
            n = sc.nextInt();
        }

        game = createLayout(n, '?');
        bombs = createLayout(n, '?');

        placeBombs(bombs, n, n);
        System.out.println("The board: \n" + printLayout(game, n));
        System.out.println("There are " + n + " bombs, FIND THEM!!!");

        printMenu();
        opt = sc.nextInt();
        option = MenuOption.values()[opt - 1];
        while (option != MenuOption.EXIT) {
            switch (option) {
                case BOMB:

                    betBomb(game, n, sc);

                    break;
                case DISCOVER:

                    resDiscover = discoverCellAndCheckNeighborhood(game, bombs, n, sc);
                    break;

                case PRINT:
                    System.out.println(printLayout(game, n));
                    break;

                case RESOLVE:
                    /* YOUR CODE GOES HERE */
                    resolve(game, bombs, n);
                    break;

                case EXIT:
                    System.out.println("Bye! :)");
                    break;
                default:
                    System.out.println("Not a valid option.");
            }
            //Este if y la variable resDiscover los agrego para tener una forma de salir del bucle sin tener que recurrir a cosas como System.exit()
            if (resDiscover == -1) {
                System.out.println(printLayout(game, n));
                System.out.println("Pisaste una bomba !!! Terminando juego...");
                option = MenuOption.EXIT;
            } else {
                printMenu();
                opt = sc.nextInt();
                option = MenuOption.values()[opt - 1];
            }


        }

    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Welcome to Minesweeper!");
        System.out.println("1. Bet a bomb (B).");
        System.out.println("2. Discover a cell.");
        System.out.println("3. Print board.");
        System.out.println("4. Resolve Game.");
        System.out.println("5. Exit.");
        System.out.println("Choose an option:");
    }

    private static int[] checkIndexes(int i, int j, int n, Scanner sc) {
        /*Aquest mètode pren dos índexs i, j, un enter n i un objecte Scanner, sc, com
        a entrada. Aleshores anirà demanant índexs a l’usuari mentre els dos índexs i, j
        no estiguin en el rang [0, n-1]. Si estiguessin en el rang, retorna un array null,
        sinó retorna un array de dues posicions on s’emmagatzemen els nous valors de i
        i de j.*/

        /*NOTA:No acabo de entender el porque ese tipo de returns , entiendo que este metodo sirve para comprobar que las coordenadas introducidas esten dentro del
        rango de la matriz y que tenemos que devolver DOS coordenadas y para eso usamos un vector,por eso no entiendo el return donde se guargdan las nuevas posiciones
        cuando estos no estan dentro del rango*/

        //Por eso modifico este metodo

        int[] vector = new int[2];
        while (!(i >= 0 && i < n && j >= 0 && j < n)) {
            System.out.println("Vuelva a Introducir los indices");
            System.out.println("Introduzca el indice de la fila");
            i = sc.nextInt();
            System.out.println("introduzca el indice de la columna");
            j = sc.nextInt();
        }
        vector[0] = i;
        vector[1] = j;
        return vector;

    }

    private static void betBomb(char[][] layout, int n, Scanner sc) {
        /*Aquest mètode pren un array bidimensional, la dimensió n de l’array nxn i un
        objecte Scanner, sc, com a entrada. Aleshores demana a l’usuari dos índexs
        per a marcar una cel·la com a cel·la amb bomba. Tingueu en compte que no
        podeu tenir més apostes de bomba que número de bombes i que heu
        d’assegurar que la consulta a l’array bidimensional es fa dintre dels límits
        definits (de 0 a n-1 en ambdues dimensions). Useu el mètode
        checkIndexes() , definit avall, per a fer això.*/

        //Primero tengo que comprobar cuantas betbombs ya hay en el tablero
        int maxBetBomb = 0, i, j;
        int[] pos;
        for (int k = 0; k < layout.length; k++) {
            for (int l = 0; l < layout.length; l++) {
                if (layout[k][l] == 'B')
                    maxBetBomb++;

            }
        }

        if (maxBetBomb >= n) {
            System.out.println("Numero maximo de betBombs que puede poner alcanzado");
        } else {
            System.out.println("Por favor indique las coordenadas domde colocar la betbomb");
            System.out.println("Coordenada de las filas");
            i = sc.nextInt();
            System.out.println("Coordenada de las columnas");
            j = sc.nextInt();
            pos = checkIndexes(i, j, n, sc);

            layout[pos[0]][pos[1]] = 'B';
        }


    }

    private static void placeBombs(char[][] layout, int n, int numBombs) {
        /*Aquest mètode pren un array bidimensional (que representa el tauler), la
        dimensió n de l’array i el nombre de bombes que hem de col·locar en l’array,
        numBombs, i retorna un array bidimensional numBombs bombes col·locades
        aleatòriament. Tingueu en compte que cada cel·la de l’array pot tenir, com a
        molt, una bomba*/
        //Las bombas estan representadas con una "B"
        int i = 0, numA, numB, min = 0, max = n - 1;

        while (i < numBombs) {//Este se encaga del nbombas
            numA = ThreadLocalRandom.current().nextInt(min, max + 1);
            numB = ThreadLocalRandom.current().nextInt(min, max + 1);
            if (layout[numA][numB] != 'B') {//Esto se encarga de no repetir el proceso
                layout[numA][numB] = 'B';
                i++;
            }
        }
    }

    private static char[][] createLayout(int n, char c) {
        /*Aquest mètode retornarà un array bidimensional de tipus char, de dimensió nxn
        on a cada cel·la hi col·locarà el caràcter c passat per paràmetre.*/
        char[][] matriz = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = c;
            }
        }
        return matriz;
    }

    private static int discoverCellAndCheckNeighborhood(char[][] layout, char[][] bombs, int n, Scanner sc) {
        /* Aquest mètode pren un array bidimensional, layout, la dimensió n i un objecte Scanner, sc. Demanarà a l’usuari dos índexs per a descobrir una
        cel·la. Si la cel·la seleccionada conté una bomba, doneu un missatge indicant que heu perdut i finalitzeu el programa. Si no conté una bomba, compteu el
        nombre de bombes que hi ha les 8 cel·les immediatament contigües (les 4 a en vertical i horitzontal, i les 4 en diagonal) i col·locareu aquest nombre a la
         cel·la seleccionada. Tingeu en compte que heu d’assegurar que els índexs demanats es troben dintre dels límits de l’array bidimensional. Useu el mètode
         checkIndexes() , definit avall, per a fer això. */

        int i, j, fila, col, numBombas = 0;
        int[] pos;

        //Esta parte del codigo se encarga de obtener unas coordenadas cons sentido del usuario
        System.out.println("Por favor indique las coordenadas domde colocar la betbomb");
        System.out.println("Coordenada de las filas");
        i = sc.nextInt();
        System.out.println("Coordenada de las columnas");
        j = sc.nextInt();
        pos = checkIndexes(i, j, n, sc);
        fila = pos[0];
        col = pos[1];

        //Primero en el caso que el usuario haya pisado una bomba retorno un valor que si es =-1 el programa terminara,tambien para que el usuario lo sepa cuando esto pase en el main llamaremos a printLayout
        if (bombs[fila][col] == 'B') {
            layout[fila][col] = 'B';
            return -1;
        }
        //Y para contar el numero de bombas alrededor solo hacemos un bucle de 3x3(la variables x,y se toman ese rol) en el que sumaremos 1 a numBombas por cada bomba
        //Para controlar que no se salga de rango las variables encargadas de las coordenadas(k y l) solo cogemos los valores donde tienen sentido osea mayor a 0  y menor a n
        else {
            for (int k = fila - 1, x = 0; x < 3; k++, x++) {
                for (int l = col - 1, y = 0; y < 3; l++, y++) {
                    if (k >= 0 && k < n && l >= 0 && l < n) {
                        if (bombs[k][l] == 'B')
                            numBombas++;
                    }

                }
            }
        }
        //Finalmente convierto el int a char
        layout[fila][col] = (char) (numBombas + '0');
        return 0;
    }


    private static void resolve(char[][] layout, char[][] bombs, int n) {
        /* Aquest mètode pren dos arrays bidimensionals, layout i bombs, i la dimensió n dels arrays nxn com a entrada. Comprovarà si en el primer array bidimensional
         s’han marcat correctament totes les caselles com a bomba, comparant-ho amb el segon array bidimensional (que conté les bombes). */

        int bombasCubiertas = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombs[i][j] == 'B') {
                    if (bombs[i][j] == layout[i][j])
                        bombasCubiertas++;

                }
            }
        }
        if (bombasCubiertas == n)
            System.out.println("Juego resulto !! :) (elija la opcion salir)");
        else
            System.out.println("Aun hay bombas por cubrir");
    }

    private static String printLayout(char[][] layout, int n) {
        int i, j;
        String output = "  | ";
        for (i = 0; i < n; i++) {
            output += i + " ";
        }
        output += '\n' + "  ";
        for (i = 0; i <= n; i++) {
            output += "- ";
        }
        output += '\n';
        for (i = 0; i < n; i++) {
            output += i + " | ";
            for (j = 0; j < n; j++) {
                output += layout[i][j] + " ";
            }
            output += '\n';
        }
        return output;
    }

}