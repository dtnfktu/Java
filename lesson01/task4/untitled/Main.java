/* Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет. */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите уравнение вида q + w = e (0 <= q, w, e <= 99): ");

        // Вводим уравнение с корректировкой - убираем пробелы и меняем & на ? (если таковой имеет мето быть)
        String equation = in.nextLine().replace(" ","").replace("&","?");

        // правая часть уравнения
        String sE = equation.split("=")[1];
        if (sE.length() == 1) sE = "0" + sE;
        int[] e = allVariants(sE);

        String sQ = equation.split("=")[0].split("\\+")[0];      // слагаемые из левой части уравнения
        if (sQ.length() == 1) sQ = "0" + sQ;                                 // в строковом представлении

        String sW = equation.split("=")[0].split("\\+")[1];      // приводим их
        if (sW.length() == 1) sW = "0" + sW;                                // к двузначному виду (если < 10, добавляем спереди 0)

        boolean noSolution = true;                                          // предполагаем, что решения нет

        // Создаём все возможные варианты значений для числа q
        int[] q = allVariants(sQ);
        // Создаём все возможные варианты значений для числа w
        int[] w = allVariants(sW);
        // И теперь перебираем все возможные их суммы
        for(int i = 0; i < q.length; i++) {
            for (int j = 0; j < w.length; j++) {
                for(int k = 0; k < e.length; k++)

                {
                    if (q[i] + w[j] == e[k]){
                        noSolution = false;
                        System.out.println(q[i] + " + " + w[j] + " = " + e[k]);
                    }
                }
            }
        }

        if (noSolution) System.out.println("Решения нет");

    }

    // Принимает строку, возвращает массив возможных значений
    static  public int[] allVariants(String expr){
        int[] arr;
        if (!expr.contains("?")) {
            arr = new int[1];
            arr[0] = Integer.parseInt(expr);
        } else {
            if (expr.equals("??")) {
                arr = new int[100];
                for(int i = 0;i < 100;i++) arr[i] = i;
            } else {
                arr = new int[10];
                if (expr.charAt(0) == '?') {
                    for(int i = 0; i < 10; i++) {
                        arr[i] = i * 10 + expr.charAt(1) - '0';
                    }
                }
                    else {
                        for(int i = 0; i < 10; i++) {
                            arr[i] = i + (expr.charAt(0) - '0') * 10;
                    }
                }
            }
        }

        return arr;
    }

}