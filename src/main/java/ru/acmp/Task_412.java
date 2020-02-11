package ru.acmp;

import java.util.Scanner;
import java.lang.Math;

public class Task_412 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String s = new String();
        int wk_x, wk_y, wf_x, wf_y, bk_x, bk_y;
        s = scan.nextLine();
        wk_x = s.charAt(0) - 97;
        wk_y = s.charAt(1) - 48;
        wf_x = s.charAt(3) - 97;
        wf_y = s.charAt(4) - 48;
        bk_x = s.charAt(6) - 97;
        bk_y = s.charAt(7) - 48;
        if(wf_x == bk_x)
        {
            if(wf_x == wk_x)
            {
                if( IFX(wk_y, wf_y, bk_y) )
                    System.out.println("YES");
                else
                    System.out.println("NO");
                System.exit(0);
            }
            System.out.println("YES");
            System.exit(0);
        }
        if(wf_y == bk_y)
        {
            if(wf_y == wk_y)
            {
                if(IFY(wk_x, wf_x, bk_x))
                    System.out.println("YES");
                else
                    System.out.println("NO");
                System.exit(0);
            }
            System.out.println("YES");
            System.exit(0);
        }
        if( Math.abs( wf_x - bk_x ) == Math.abs( wf_y - bk_y ) )
        {
            if( Math.abs( wf_x - wk_x ) == Math.abs( wf_y - wk_y ) )
            {
                if( IFX( wk_y, wf_y, bk_y ) || IFY( wk_x, wf_x, bk_x ) )
                {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
            else
            {
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");
    }
    static boolean IFX(int wk_y, int wf_y, int bk_y)
    {
        if( (wf_y > wk_y && bk_y > wk_y) || (wf_y < wk_y && bk_y < wk_y) )
            return true;
        return false;
    }
    static boolean IFY(int wk_x, int wf_x, int bk_x)
    {
        if( (wf_x > wk_x && bk_x > wk_x) || (wf_x < wk_x && bk_x < wk_x) )
            return true;
        return false;
    }
}