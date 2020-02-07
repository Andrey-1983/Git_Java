package com.company;

import java.util.Scanner;

public class Main {
    public static boolean mx[][] = new boolean[100][100];
    public static boolean b[] = new boolean[100];
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n, m;
        n = scan.nextInt();
        m = scan.nextInt();
	    for(int a = 0; a < n; ++a)
        {
            for(int i = 0; i < n; ++i)
            {
                mx[a][i] = false;
            }
        }
        for(int a = 0; a < n; ++a)
        {
            b[a] = false;
        }
        for(int a = 0; a < m; ++a)
        {
            mx[scan.nextInt()][scan.nextInt()] = true;
        }
        for(int a = 0; a < n; ++a)
        {
            Search(a, n);
        }
        System.out.println("Yes");
        System.exit(0);
    }
    static void Search(int a, int n)
    {
        b[a] = true;
        for(int i = 0; i < n; ++i)
        {
            if(mx[a][i])
            {
                if(b[i])
                {
                    System.out.println("No");
                    System.exit(0);
                }
                else
                {
                    Search(i, n);
                }
            }
        }
        b[a] = false;
    }
}
