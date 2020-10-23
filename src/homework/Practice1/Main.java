package homework.Practice1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int fac(int a)
    {
        int result = 1;
        for (int i = 1; i <=a; i ++){
            result = result*i;
        }
        return result;
    }


    public static void main(String[] args)
    {
        int sum=0;
        Random ran = new Random();
        int amount = ran.nextInt(100);
        int[] arr = new int[amount];

        // заполнение массива
        for(int i = 0; i < arr.length; ++i)
            arr[i] = ran.nextInt(10000);


        // блок суммирования
        for(int i = 0; i < arr.length; ++i)
            sum+=arr[i];
        System.out.println(sum);


        sum=0;
        int j = 0;
        while(j < arr.length)
        {
            sum+=arr[j];
            ++j;
        }
        System.out.println(sum);

        sum = 0;
        j = 0;
        do {
            sum+=arr[j];
            ++j;
        } while (j < arr.length);
        System.out.println(sum);

        // блок вывода массива
        for (int item :
                arr) {
            System.out.printf(" %d", item);
        }

        // блок вывода отсортированного массива
        System.out.println();
        Arrays.sort(arr);
        for (int item :
                arr) {
            System.out.printf(" %d", item);
        }

        // блок заполнения math'ом
        for(int i = 0; i < arr.length; ++i)
            arr[i] = (int) (Math.random() * 10);

        // блок вывода массива
        System.out.println();
        for (int item :
                arr) {
            System.out.printf(" %d", item);
        }

        // блок вывода отсортированного массива
        System.out.println();
        Arrays.sort(arr);
        for (int item :
                arr) {
            System.out.printf(" %d", item);
        }

        // блок вычисления факториала
        System.out.println();
        System.out.println(fac(11));
    }
}
