// Пусть дан произвольный список целых чисел. Удалить все четные числа

package lesson03;
import java.util.ArrayList;

public class MinMaxAvg {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = initArray();          // Создаём массив случайных чисел случайной длины
        System.out.println("Исходный массив (длина = " + list.size() + ")");
        System.out.println(printArray(list));           // Выводим исходный массив
        System.out.println("Минимальный элемент  = " + getMin(list));
        System.out.println("Максимальный элемент = " + getMax(list));
        System.out.println("Среднее значение     = " + getAvg(list));
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

    // Возвращает минимальный элемент списка
    public static int getMin(ArrayList<Integer> array) {
        int ans = array.get(0);
        for(int i = 0;i < array.size();i++) {
            if (array.get(i) < ans) ans = array.get(i);
        }
        return ans;
    }
    // Возвращает максимальный элемент списка
    public static int getMax(ArrayList<Integer> array) {
        int ans = array.get(0);
        for(int i = 0;i < array.size();i++) {
            if (array.get(i) > ans) ans = array.get(i);
        }
        return ans;
    }

    // Возвращает среднее значение элементов списка
    public static int getAvg(ArrayList<Integer> array) {
        int ans = 0;
        for(int i = 0;i < array.size();i++) {
            ans += array.get(i);
        }
        return ans / array.size();
    }    

}
