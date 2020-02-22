package ru.acmp;

import java.util.Scanner;

public class Task_804 {
    static Scanner in = new Scanner(System.in);

    static int[][] mx = new int[1000][1000];
    static int[][] map = new int[1000000][2];

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        int tigerX = 0;
        int tigerY = 0;
        for (int x = 0; x < n; ++x) {
            String line = in.nextLine();
            for (int y = 0; y < m; ++y) {
                switch (line.charAt(y)) {
                    case '.':
                        mx[x][y] = 0;
                        break;
                    case '#':
                        mx[x][y] = 1;
                        break;
                    case 'T':
                        tigerX = x;
                        tigerY = y;
                        break;
                }
            }
        }

        map[0][0] = 1;
        map[0][1] = 1;
        mx[1][1] = 2;
        int indexM = getIndex(n, m, 2);

        map[0][0] = tigerX;
        map[0][1] = tigerY;
        mx[tigerX][tigerY] = 3;
        int indexT = getIndex(n, m, 3);

        System.out.println(indexM);
        System.out.println(indexM < indexT ? "Yes" : "No");
    }

    static int getIndex(int n, int m, int val) {
        int bg = 0;
        int ed = 1;
        int indexT = 0;
        while (true) {
            int c = func(bg, ed, n, m, val);
            if (c == -1) return indexT;
            if (val == 3 && c == -2) return 1000000;
            bg = ed;
            ed += c;
            ++indexT;
        }
    }

    static int func(int bg, int ed, int n, int m, int val) {
        int x, y, c = 0;
        boolean log = true;
        for (int a = bg; a < ed; ++a) {
            x = map[a][0];
            y = map[a][1];
            if (x == n - 2 && y == m - 2) {
                return -1;
            }
            if (mx[x][y + 1] != 1 && mx[x][y + 1] != val) {
                log = false;
                mx[x][y + 1] = val;
                map[ed + c][0] = x;
                map[ed + c][1] = y + 1;
                c++;
            }
            if (mx[x][y - 1] != 1 && mx[x][y - 1] != val) {
                log = false;
                mx[x][y - 1] = val;
                map[ed + c][0] = x;
                map[ed + c][1] = y - 1;
                c++;
            }
            if (mx[x + 1][y] != 1 && mx[x + 1][y] != val) {
                log = false;
                mx[x + 1][y] = val;
                map[ed + c][0] = x + 1;
                map[ed + c][1] = y;
                c++;
            }
            if (mx[x - 1][y] != 1 && mx[x - 1][y] != val) {
                log = false;
                mx[x - 1][y] = val;
                map[ed + c][0] = x - 1;
                map[ed + c][1] = y;
                c++;
            }
        }
        return log ? -2 : c;
    }
}