package Practice18;

public class Ex2 {
    public static void main(String[] args) {
        String input = "улыбок тебе дед макар", str1;
        str1 = input.substring(0, input.length()/2);
        StringBuilder str2 = new StringBuilder(input.substring((input.length()/2) + input.length()%2));
        str2.reverse();
        if (str1.equals(str2.toString()))
            System.out.println("YES");
        else System.out.println("NO");
    }
}
