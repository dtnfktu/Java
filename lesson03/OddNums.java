// Пусть дан произвольный список целых чисел. Удалить все четные числа

package lesson03;
import java.util.ArrayList;

public class OddNums {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = initArray();          // Создаём массив случайных чисел случайной длины
        System.out.println("Исходный массив (длина = " + list.size() + ")");
        System.out.println(printArray(list));           // Выводим исходный массив
        delEvenNums(list);                              // Удаляем четные числа
        System.out.println("Полученный массив (длина = " + list.size() + ")");
        System.out.println(printArray(list));           // Выводим массив после удаления четных элементов
    }

    // Создаём целочисленный массив
    public static ArrayList<Integer> initArray (){
        ArrayList<Integer> list = new ArrayList<>();
        int arrayLen = (int) (Math.random() * 50);      // Задаём длину списка случайным образом
        for(int i = 0; i < arrayLen; i++) {
            list.add((int) (Math.random() * 100));      // Задаём элемент списка - случайное число
        }
        return list;
    }

    // Выводим содержимое массива
    public static String printArray(ArrayList<Integer> array) {
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < array.size(); i++) {
            ans.append(array.get(i) + " ");
        }
        return ans.toString();
    }

    // Удаляем чётные элементы - проходим массив с конца
    public static void delEvenNums(ArrayList<Integer> array) {
        for(int i = array.size() - 1; i >= 0 ; i--) {
            if (array.get(i) % 2 == 0) {
                array.remove(i);
            }
        }
    }

}
