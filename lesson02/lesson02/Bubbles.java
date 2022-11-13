/* Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
Сортировка методом пузырька немного модифицирована:
- каждый следующий прогон на один шаг меньше по сравнению с предыдущим,
  т.к. один элемент 100% за проход встал на своё место (последнее, предпоследнее, т .д.)
- на каждом шаге идёт сравнение текущего состояния массива с предыдущим.
  Если отличий нет - break, завершение цикла - всё отсортировано
 Результаты итераций пишутся в bubbles.log
*/

import java.io.FileWriter;

public class Bubbles
{
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("bubble.log", false);
            // Задаём массив случайных чисел
            int arrLen = 20;
            int[] array = new int[arrLen];
            for(int i = 0; i < arrLen; i++) {
                array[i] = (int) (Math.random() * 100);
            }
            // Выводим на результат итерации
            String strArray = printArray(array);
            fw.append("Step 0:\n");
            fw.append(strArray + "\n");

            for(int i = 0; i < array.length; i++) {
                oneStep(array, i);
                if (strArray.equals(printArray(array))) break;
                strArray = printArray(array);
                fw.append("Step " + (i + 1)  +":\n");
                fw.append(strArray + "\n");
            }

            fw.close();

        } catch(Exception e) {
            System.out.print("Error");
        }


    }

    // Вывод массива в консоль
    public static String printArray(int[] mas) {
        StringBuilder out = new StringBuilder("");
        for(int i = 0; i < mas.length; i++) {
            out.append(mas[i] + " ");
        }
        return out.toString();
    }

    // Один проход по массиву
    public static void oneStep(int[] mas, int steps) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < mas.length - steps - 1; i++){
            if (mas[i] > mas[i + 1]){
                int tmp = mas[i];
                mas[i] = mas[i + 1];
                mas[i + 1] = tmp;
            }
        }
    }

}
