package Practice19;

import java.io.*;
import java.util.Scanner;

public class FileInteraction {
    public static void printFile(File file) throws IOException {
        //выводим всю инфу
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println("File content:");
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }
        bufferedReader.close();
        fileReader.close();
    }

    public static void writeFile(File file) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите информацию, которую нужно записать в файл");
        System.out.println("Введите \'0\', чтобы остановить ввод");
        String input = "";

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.flush();

        // записываем новую инфу
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while (true){
            input = sc.nextLine();
            if (input.equals("0"))
                break;
            bufferedWriter.write(input);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void appendFile(File file) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите информацию, которую нужно записать в файл");
        System.out.println("Введите \'0\', чтобы остановить ввод");
        String input = "";

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.flush();

        // Дополняем инфу
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while (true){
            input = sc.nextLine();
            if (input.equals("0"))
                break;
            bufferedWriter.write(input);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        path += "/src/Practice19/file.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }

        //перезаписываем по новой файл
        writeFile(file);

        //добавляем инфу в файл
        appendFile(file);

        //считываем весь файл
        printFile(file);
    }
}
