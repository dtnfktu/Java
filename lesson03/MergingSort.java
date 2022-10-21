// Реализовать алгоритм сортировки слиянием

package lesson03;
import java.util.ArrayList;;


public class MergingSort {
    
    public static void main(String[] args) {
        // Создаём массив случайных чисел случайной длины
        ArrayList<Integer> list = initArray();          
        System.out.println("Исходный массив : \n" + printArray(list));
        // Сортируем слиянием
        //list = mergeSort(list);
        System.out.println("Отсортированный массив : \n" + printArray(mergeSort(list)));
    }

    // Создаём целочисленный массив
    public static ArrayList<Integer> initArray (){
        ArrayList<Integer> list = new ArrayList<>();
        int arrayLen = 20;                              // Задаём длину списка случайным образом
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

    // Слияние двух отсортированных массивов в один отсортированный по возрастанию
    public static ArrayList<Integer> mergeArrays(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        ArrayList<Integer> outArray = new ArrayList<>();                // Результирующий массив
        int i1 = 0;                                                     // Текущая позиция в массиве 1
        int i2 = 0;                                                     // Текущая позиция в массиве 2
        int outLen = array1.size() + array2.size();                     // Длина результирующего массива
        
        for(int i = 0; i < outLen; i++) {
            if (i1 >= array1.size()) {                  // Если первый массив "закончился", а второй ещё нет
                outArray.add(array2.get(i2++));
            } else if (i2 >= array2.size()) {           // Если второй массив "закончился", а первый нет
                outArray.add(array1.get(i1++));
            } else if (array1.get(i1) < array2.get(i2)) {
                outArray.add(array1.get(i1++));
            } else {
                outArray.add(array2.get(i2++));
            }
        }

        return outArray;
    }
    
    // Рекурсивная функция, разбивающая массив пополам
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        //Если массив пустой, то возвращаем null
        if (array.size() == 0) {
            return null;
        }
        // Если длина массива = 1, то возвращаем массив
        if (array.size() < 2) {
            return array;
        }
        // Создаём левую половинку массива
        ArrayList<Integer> leftArray = new ArrayList<>();
        for(int i = 0; i < array.size() / 2; i++) leftArray.add(array.get(i));
        // Создаём правую половинку массива
        ArrayList<Integer> rightArray = new ArrayList<>();
        for(int i = array.size() / 2; i < array.size() ; i++) rightArray.add(array.get(i));


        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        // Возвращаем слитые отсортированные массивы
        return mergeArrays(leftArray, rightArray);
    }

}
