package lesson05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;


public class Names {
    
    public static void main(String[] args) {
        LinkedList<String> names = readFromFile("staff.txt");
        HashMap<String,Integer> countNames = new HashMap<>();

        for(String name: names) {
            String nam = name.split(" ")[0];        // первое слово - имя
            int counter;
            if (!countNames.containsKey(nam)) {
                counter = 1;                                // если имя встретилось впервые
            } else {
                counter = countNames.get(nam) + 1;          // если имя уже было
            }
            countNames.put(nam, counter);
        }

        // выводим результат
        for(String nam : countNames.keySet()) {
            System.out.println(countNames.get(nam) + " - " + nam);
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
                list.add(line);
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
