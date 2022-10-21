// Реализовать простой калькулятор
// К калькулятору из предыдущего дз добавить логирование.

import java.util.Scanner;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Calc
{
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Logger logger = Logger.getLogger(Calc.class.getName());
        logger.setUseParentHandlers(false);
        logger.log(Level.INFO, "Запуск калькулятора");
        FileHandler fh;
        
        try {  
            fh = new FileHandler("calc.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        
        System.out.print("Введите первое число (целое) : ");
        int a = in.nextInt();
        logger.log(Level.INFO, "Ввод числа 1 :" + a);
        System.out.print("Введите знак операции (+ - * /) : ");
        char oper = in.next().charAt(0);
        logger.log(Level.INFO, "Ввод знака операции :" + oper);
        System.out.print("Введите второе число (целое) : ");
        int b = in.nextInt();
        logger.log(Level.INFO, "Ввод числа 2 :" + b);
        System.out.print(a + " " + oper + " " + b + " = ");

        switch(oper) {
            case '+' :  System.out.print(a + b);
                logger.log(Level.INFO, a + " " + oper + " " + b + " = " + (a + b));
                break;
            case '-' :  System.out.print(a - b);
                logger.log(Level.INFO, a + " " + oper + " " + b + " = " + (a - b));
                break;
            case '*' :  System.out.print(a * b);
                logger.log(Level.INFO, a + " " + oper + " " + b + " = " + (a * b));
                break;
            case '/' :  case '\\' :
                if (b != 0) {
                    if (a % b == 0) {
                        System.out.print(a / b);
                        logger.log(Level.INFO, a + " " + oper + " " + b + " = " + (a / b));
                    } else {
                        System.out.print((float) a / b);
                        logger.log(Level.INFO, a + " " + oper + " " + b + " = " + ((float) a / b));
                    }
                } else {
                    System.out.print("Делить на ноль нельзя!");
                    logger.log(Level.WARNING, "Деление на ноль");
                }

                break;

        }
        logger.log(Level.INFO, "Завершение работы");
    }
}