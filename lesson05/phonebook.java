// Реализовать структуру телефонной книги с помощью HashMap. Учесть, что у одного человека может быть несколько телефонных номеров


package lesson05;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class phonebook {
    public static void main(String[] args) {
        HashMap<String,LinkedList<String>> phBook = new HashMap<>();
        LinkedList<String> list = readFromFile("staff.txt");

        for(String names:list) {
            String name
        }



    }
        
    public static LinkedList<String> readFromFile(String fileName){
        LinkedList<String> list = new LinkedList<>();
        try {
            FileReader fr = new FileReader(new File(fileName));
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }






}
