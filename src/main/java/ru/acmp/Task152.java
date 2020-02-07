package ru.acmp;

import java.util.Scanner;

class Task152 {
    static final Scanner sc = new Scanner(System.in);

    static final boolean[][] mx = new boolean[100][100];
    static final boolean[] b = new boolean[100];

    public static void main(String[] args) {
        final int n = sc.nextInt();
        final int m = sc.nextInt();

//        for (int a = 0; a < n; ++a) {
//            for (int i = 0; i < n; ++i) {
//                mx[a][i] = false; // необязательно это делать - по умолчанию там уже false.
//            }
//        }

//        for (int a = 0; a < n; ++a) {
//            b[a] = false; // необязательно это делать - по умолчанию там уже false.
//        }

        for (int i = 0; i < m; ++i) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            mx[a][b] = true;
            // будет IndexOutOfBoundsException, если b == mx.length (т.е. b == 100).
        }
        for (int a = 0; a < n; ++a) {
            Search(a, n);
        }
        System.out.println("Yes");
//        System.exit(0); // не нужно - программа завершится при завершении метода main.
    }

    static void Search(int a, int n) {
        b[a] = true;
        for (int i = 0; i < n; ++i) {
            if (!mx[a][i]) {
                continue;
            }
            if (b[i]) {
                System.out.println("No");
                System.exit(0);
            }
            Search(i, n);
        }
        b[a] = false;
    }
}
