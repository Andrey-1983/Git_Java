package ru.acmp;

import java.util.Scanner;

public class Task_804
{
    static int[][] mx = new int[1000][1000];
    static int[][] map = new int[1000000][2];
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int m, n, tiger_x = 0, tiger_y = 0;
        n = scan.nextInt();
        m = scan.nextInt();
        String str = new String();
        str = scan.nextLine();
        for(int a = 0; a < n; ++a)
        {
            str = scan.nextLine();
            for(int i = 0; i < m; ++i)
            {
                char s = str.charAt(i);
                if (s == '.')
                {
                    mx[a][i] = 0;
                }
                else if (s == '#')
                {
                    mx[a][i] = 1;
                }
                else if (s == 'T')
                {
                    tiger_x = a;
                    tiger_y = i;
                }
            }
        }
        int bg = 0, ed = 1, indexM = 0, indexT = 0;
        map[0][0] = 1;
        map[0][1] = 1;
        mx[1][1] = 2;
        while(true)
        {
            int c = Func(bg, ed, n, m, 2);
            if(c == -1)
                break;
            bg = ed;
            ed += c;
            indexM++;
        }

        bg = 0;
        ed = 1;
        map[0][0] = tiger_x;
        map[0][1] = tiger_y;
        mx[tiger_x][tiger_y] = 3;
        while(true)
        {
            int c = Func(bg, ed, n, m, 3);
            if(c == -1)
                break;
            else if(c == -2)
            {
                indexT = 1000000;
                break;
            }
            bg = ed;
            ed += c;
            indexT++;
        }
        System.out.println(indexM);
        if(indexM >= indexT)
            System.out.println("No");
        else
            System.out.println("Yes");
    }

    static int Func(int bg, int ed, int n, int m, int val)
    {
        int x, y, c = 0;
        boolean log = true;
        for(int a = bg; a < ed; ++a)
        {
            x = map[a][0];
            y = map[a][1];
            if(x == n - 2 && y == m - 2)
            {
                return -1;
            }
            if(mx[x][y + 1] != 1 && mx[x][y + 1] != val)
            {
                log = false;
                mx[x][y + 1] = val;
                map[ed + c][0] = x;
                map[ed + c][1] = y + 1;
                c++;
            }
            if(mx[x][y - 1] != 1 && mx[x][y - 1] != val)
            {
                log = false;
                mx[x][y - 1] = val;
                map[ed + c][0] = x;
                map[ed + c][1] = y - 1;
                c++;
            }
            if(mx[x + 1][y] != 1 && mx[x + 1][y] != val)
            {
                log = false;
                mx[x + 1][y] = val;
                map[ed + c][0] = x + 1;
                map[ed + c][1] = y;
                c++;
            }
            if(mx[x - 1][y] != 1 && mx[x - 1][y] != val)
            {
                log = false;
                mx[x - 1][y] = val;
                map[ed + c][0] = x - 1;
                map[ed + c][1] = y;
                c++;
            }
        }
        if(log)
            return  -2;
        else
            return c;
    }
}