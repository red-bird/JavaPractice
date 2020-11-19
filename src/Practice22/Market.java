package Practice22;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    String name;
    String fullname;
    String patronymic;
    String INN;

    public User(String name, String fullname, String patronymic, String INN) {
        this.name = name;
        this.fullname = fullname;
        this.patronymic = patronymic;
        this.INN = INN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }
}

public class Market {
    public static void main(String[] args) {
        ArrayList<User> userLst = new ArrayList<User>();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        for (int i = 0; i < 5; i++) {
            System.out.print("Введито ФИО и ИНН\n");
            String name = sc.next();
            String fullname = sc.next();
            String patronymic = sc.next();
            String INN = sc.next();

            if (INN.length() != 12) {
                System.out.println("Bad individual tax number");
                continue;
            } else {
                for (int j = 0; j < userLst.size(); j++)
                    if (userLst.get(j).INN.equals(INN)) {
                        System.out.println("Your INN already in our database!");
                        flag = false;
                        break;
                    }
                if (flag) {
                    userLst.add(new User(name, fullname, patronymic, INN));
                    System.out.println("You were added!");
                }
                flag = true;
            }
        }
//        Результаты теста программы:

//        Введито ФИО и ИНН
//        Smith Svetlana Igorevna 012345678901
//        You were added!
//        Введито ФИО и ИНН
//        Smith Svetlana Igorevna 012345678901
//        Your INN already in our database!
//        Введито ФИО и ИНН
//        Smith Svetlana Igorevna 0123456789
//        Bad individual tax number
//        Введито ФИО и ИНН
//        Smith Cherkizova Igorevna 123456789012
//        You were added!
//        Введито ФИО и ИНН
//        Smith Svetlana Igorevna 098765432101
//        You were added!
    }
}
