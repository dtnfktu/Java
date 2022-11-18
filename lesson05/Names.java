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
            if (!countNames.containsKey(nam)) {
                countNames.put(nam, 1);                         // имя встретилось впервые
            } else {
                countNames.put(nam, countNames.get(nam) + 1);          // имя встречалось
            }
         }

        // Удаляем неповторяющиеся имена - те, у которых количество повторений =1
        // Сначала находим эти имена и собираем в отдельный LinkedList
        LinkedList<String> keyForDel = new LinkedList<>();
        for(String key : countNames.keySet()){
            if (countNames.get(key) == 1) {
                keyForDel.add(key);
            }
        // А затем удаляем их из HashMap, удаление элемента Map преборе этого Map (в предыдущем цикле) не допустимо
        }
        for(String key : keyForDel) {
            countNames.remove(key);
        }

        // выводим результат - подсмотрено на stackoverflow.com ))
        countNames.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
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