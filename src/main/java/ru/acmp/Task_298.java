package ru.acmp;

import java.util.HashMap;
import java.util.Scanner;

public class Task_298 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        HashMap <Float, Integer> h_12 = new HashMap<>();
        HashMap <Float, Integer> h_34 = new HashMap<>();
        int n = scan.nextInt();
        for(int a = 0; a < n; ++a)
        {
            float x = scan.nextFloat(), y = scan.nextFloat();
            if(y > 0)
                h_12.put(y/x, 1);
            else
                h_34.put(y/x, 1);
        }
        System.out.println(h_12.size() + h_34.size());
    }
}
