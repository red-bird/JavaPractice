package homework.Practice10;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int k, d;
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        d = sc.nextInt();
        int min = (int)Math.pow(10, k - 1);
        int count = 0, sum, num;
        for (int i = min; i < min*10; i++) {
            sum = 0;
            num = i;
            while (num != 0){
                sum += num%10;
                num /= 10;
            }
            if (sum == d)
                count++;
        }
        System.out.println(count);
    }
}