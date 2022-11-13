import java.util.Scanner;

public class Palindrome
{
    public static void main(String[] args) {
        System.out.print("Введите строку : ");
        // считываем строку и сразу приводим к нижнему регистру
        String myString = (new Scanner(System.in)).nextLine().toLowerCase();

        // 1 способ - используем инструменты Java
        // переворачиваем строку, используя StringBuilder
        String revString = (new StringBuilder(myString).reverse().toString());
        // Сравниваем введенную строку с её зеркальным отображением
        System.out.println(myString.equals(revString) ? "Да, это палиндром!" : "Нет, это не палиндром...");

        // 2 способ - используем свой метод проверки
        System.out.print(isPalindrome(myString) ? "Да, это палиндром!" : "Нет, это не палиндром...");

    }

    public static boolean isPalindrome(String str) {
        boolean result = true;
        int i = 0;
        while (i < str.length() / 2 && result){
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) result = false;
            i++;
        }
        return result;
    }

}