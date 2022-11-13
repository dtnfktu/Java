// Слегка модифицировнная сортировка методом пузырька
// На каждом прогоне количество шагов уменьшается на 1
// т.к. в результате одного прогона один элемент 100% встаёт на своё место.
// + если после текущего прогона массив не изменился, то сортировка окончена -
// в зависимости от начального состояния может существенно сократить количество лишних шагов
import java.io.FileWriter;

public class Bubblesort
{
    public static void main(String[] args) {

        // Задаём массив случайных чисел
        int arrLen = 20;
        int[] array = new int[arrLen];
        for(int i = 0; i < arrLen; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        // Сверяем массив с предыдущим шагом. Если изменений нет - сортировка завершена
        String sArray = printString(array);

        // Выводим на экран неотсортированный массив случайных чисел
        System.out.println(sArray);

        try {
            FileWriter fw = new FileWriter("bubble.log", false);
            fw.append("Step 0 (unsorted) :\r");
            fw.append(printString(array) + "\r");
            for(int i = 0; i < array.length; i++) {
                oneStep(array, i);
                if (sArray.equals(printString(array))) break;   // Массив отсортирован, цикл прерывается
                sArray = printString(array);
                fw.append("Step " + (i + 1) + ":\r");
                fw.append(printString(array) + "\r");
            }

            fw.close();
        } catch(Exception e) {
            System.out.print("Error");
        }
        System.out.println(printString(array));
    }

    // Вывод массива в виде строки
    public static String printString(int[] mas){
        StringBuilder sB = new StringBuilder("");
        for(int i = 0; i < mas.length; i++) {
            sB.append(mas[i] + " ");
        }
        return  sB.toString();
    }

    // Один проход по массиву
    // mas - текущее состояние массива, steps - количество элементов на своём месте (с каждым шагом +1)
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
