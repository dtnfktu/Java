// Пусть дан список сотрудников: Иван Иванов...
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности Имени.

// Решение.
// Чтобы не вводить имена с консоли, они считываются из файла staff.txt
// В файле каждые Имя и Фамилия записаны с новой строки. Сначала Имя, затем, через пробел, Фамилия
// Имена заносятся в LinkedList
// Создаём HashMap "countNames", в котром Имя - ключ,значение - количество повторений
// Пробегаемся по LinkedList, отделяя имена и фамилии.
// Если в HashMap текущего имени (ключа) еще нет, то записываем его со значением 1
// Если же имя уже есть, то увеличиваем значение на +1.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



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

        // выводим результат - подсмотрено на stackoverflow.com ))
        countNames.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);

        // Но нас интересуют повторяющиеся имена, т.е. значения > 1
        LinkedList<Map> answer = new LinkedList<>();
        for(countNames.)
        


        

    }

    // считываем список сотрудников построчно и записываем его в LinkedList
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
