// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите число N : ");
            int n = sc.nextInt();
            System.out.println("Треугольное число N = " + triangleNum(n));
            System.out.println("Факториал N! = " + factorialNum(n));
        }
    }

    // Возвращает треугольное число N
    static int triangleNum(int N) {
        int ans = 0;
        for(int i = 1;i <= N; i++) ans += i;
        return ans;
    }

    // Возвращает факториал чиал N
    static int factorialNum(int N) {
        int ans = 1;
        for(int i = 1;i <= N; i++) ans *= i;
        return ans;
    }
}