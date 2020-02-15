package ru.acmp;

import java.util.Scanner;

class Task_152
{
    static final Scanner sc = new Scanner(System.in);
    static boolean[][] mx = new boolean[100][100];
    static boolean[] b = new boolean[100];
    static boolean[] log = new boolean[100];

    public static void main(String[] args)
    {
        final int n = sc.nextInt();
        final int m = sc.nextInt();
        for (int i = 0; i < m; ++i)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            mx[a][b] = true;
        }
        for (int a = 0; a < n; ++a)
        {
            if(!log[a])
                Search(a, n);
        }
        System.out.println("Yes");
    }

    static void Search(int a, int n)
    {
        b[a] = true;
        for (int i = 0; i < n; ++i)
        {
            if(mx[a][i])
            {
                if (b[i])
                {
                    System.out.println("No");
                    System.exit(0);
                }
                if (!log[i])
                {
                    Search(i, n);
                }
            }
        }
        b[a] = false;
        log[a] = true;
    }
}
