package Practice10;

import java.util.Scanner;

public class Ex2 {
    public static int rec(int a, int b) {
        if (a == 0)
            return 1;
        if (a == 1)
            return b + 1;
        if (b == 0)
            return 0;
        return rec(a, b - 1) + rec(a - 1, b - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(rec(sc.nextInt(), sc.nextInt()));
    }
}
