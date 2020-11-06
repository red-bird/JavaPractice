package Practice18;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex3 {
    public static int getMax(ArrayList args){
        int max = (int)args.get(0);
        for (int i = 1; i < args.size(); ++i){
            if ((int)args.get(i) > max){
                max = (int)args.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList arr = new ArrayList();
        int tmp;

        tmp = sc.nextInt();

        while (tmp != 0){
            arr.add(tmp);
            tmp = sc.nextInt();
        }
        System.out.println(getMax(arr));

}
}

