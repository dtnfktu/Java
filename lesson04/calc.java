// В калькулятор добавьте возможность отменить последнюю операцию.

// Решение.
// Калькулятор работает как с целыми, так и с вещественными числами.
// Четыре возможные операции - + - * /
// На каждом шаге допускается выполнение только одной операции между двумя числами.
// При этом допускается вводить как два числа и знак между ними (наример, 1+2)
// так и знак с числом (например, *3.2)
// Число справа от знака операции всегда положительное!
// При запуске программы создаётся LinkedList - history. И сразу создаётся элемент = 0.0 - начальное значение.
// В начало списка заносится результат последней операции. В списке в каждый момент времени присутствует, как минимум, один элемент.

// Для отмены последней операции следует ввести         cancel
// Для завершения работы калькулятора следует ввести    stop






package lesson04;

import java.util.LinkedList;
import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Double> history = new LinkedList<>();
        history.add(0.0);                                       // начальный результат - 0.0
        String command = "";
        // Для завршения работы следует ввести команду stop
        do {
            command = scanner.nextLine().toLowerCase();             // при вводе команды сразу переводим в нижний регистр
            command.replace(',', '.');             // заменяем запятые точками в дробных чилах
            command.replace(" ", "");           // удаляем возможные пробелы
            
            if (command.equals("stop")) break;             // завершаем работу - команда stop

            if (command.equals("cancel")) {                // введена команда cancel - отходим на шаг назад

                if (history.size() > 1) history.removeFirst();
                System.out.println(history.getFirst());
                continue;
            }

            // введено арифметическое действие с числом
                                                                                                // знак - число
            if (isOperation(command.substring(0,1))) {
                String sgn = command.substring(0,1);
                double num = Double.parseDouble(command.substring(1));
                history.add(0, resultOperation(history.getFirst(), num, sgn));
            } else {                                                                            // число - знак - число
                String sgn = getSign(command);      // получаем знак операции
                double num1 = Double.parseDouble(command.substring(0, command.indexOf(sgn)));   // число слева
                double num2 = Double.parseDouble(command.substring(command.indexOf(sgn) + 1));              // число справа
                history.add(0,resultOperation(num1, num2, sgn));
            }
            System.out.println(history.getFirst());


        } while (!command.equals("stop"));

        scanner.close();
        System.out.println("Calculator shut down");
    }

    // возвращает знак операции из строки
    public static String getSign(String str) {
        if (str.contains("+")) return "+";
        if (str.contains("-")) return "-";
        if (str.contains("*")) return "*";
        if (str.contains("/")) return "/";
        return "";
    }

    // возвращает результат операции (sign) между a и b
    public static double resultOperation(double a, double b, String sign) {
        double res = 0;
        switch(sign) {
            case "+" : res = a + b;
                break;
            case "-" : res = a - b;
                break;
            case "*" : res = a * b;
                break;
            case "/" : if (b != 0) res = a / b;
                break;
        }

        return res;
    }

    // проверка строки - является ли она знаком операции
    public static boolean isOperation(String str){
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) ? true : false;
    }

    // проврека строки - является ли она числом
    public static boolean isNumeric(String str) {
        try {
          Double.parseDouble(str);
          return true;
        } catch(NumberFormatException e){
          return false;
        }
      }
}
