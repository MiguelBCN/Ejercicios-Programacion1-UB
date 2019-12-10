package com.miguelub;

import java.util.Scanner;

public class Nombres {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n, m;
        n = entrada.nextInt();
        m = n;
        while (n != 0) {
            System.out.println(m+" "+n);
            if (n < m)
                m = n;
            n = entrada.nextInt();
        }
        System.out.print("m vale: " + m);
        System.out.println(", n vale: " + n);
    }
}
