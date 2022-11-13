// Реализовать простой калькулятор

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите первое число (целое) : ");
        int a = in.nextInt();
        System.out.print("Введите знак операции (+ - * /) : ");
        char oper = in.next().charAt(0);
        System.out.print("Введите второе число (целое) : ");
        int b = in.nextInt();
        System.out.print(a + " " + oper + " " + b + " = ");

        switch(oper) {
            case '+' :  System.out.print(a + b);
                break;
            case '-' :  System.out.print(a - b);
                break;
            case '*' :  System.out.print(a * b);
                break;
            case '/' :  case '\\' :
                if (b != 0) {
                    if (a % b == 0) {
                        System.out.print(a / b);
                    } else {
                        System.out.print((float) a / b);
                    }
                } else {
                    System.out.print("Делить на ноль нельзя!");
                }

                break;

        }
    }
}