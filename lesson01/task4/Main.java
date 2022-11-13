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
        
        int e = Integer.parseInt(equation.split("=")[1]);        // правая часть уравнения - без знака '?' - только целое неотрицательное число
        
        String sQ = equation.split("=")[0].split("\\+")[0];      // слагаемые из левой части уравнения
        if (sQ.length() == 1) sQ = "0" + sQ;                       // в строковом представлении
        String sW = equation.split("=")[0].split("\\+")[1];      // приводим их 
        if (sW.length() == 1) sW = "0" + sW;                       // к двузначному виду (если < 10, добавляем спереди 0)
        
        boolean noSolution = true;                               // предполагаем, что решения нет
        
        // Создаём все возможные варианты значений для числа q
        

        
        
        
        
        
        
    }

    
    // Проверяет верность утверждения a + b = c
    static boolean isRightSum(int a, int b, int c) {
        return (a + b) == c;
    }
}
