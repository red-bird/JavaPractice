package Practice18;

import java.util.Scanner;

class PrimeFactorization {
    public void work(int number) {
        for (int i = 2; i <= Math.sqrt(number);){
            if(number % i ==0){
                System.out.print(i);
                number /= i;
                if(number > 1)
                    System.out.print(' ');
            }
            else
                i++;
        }
        if(number > 1)
            System.out.print(number);
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrimeFactorization primeFactorization = new PrimeFactorization();
        primeFactorization.work(sc.nextInt());
    }
}