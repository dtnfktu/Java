// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

// Решение.
// Для наглядности возьмём LinkedList типа char
// Решение выполнено в двух вариантах:
// 1 - метод newReverseList формирует новый LinkedList, являющийся зеркалом исходного
// 2 - метод reverseList отображает исходный LinkedList


package lesson04;

import java.util.LinkedList;

public class reverseLList {
    public static void main(String[] args) {
        int LIST_LEN = 10;
        LinkedList<Character> list = new LinkedList<>();

        // Задаём список случайных символов
        for(int i = 0; i < LIST_LEN; i++) {
            list.add((char) ('A' + (int) (Math.random() * 52)));
        }
        System.out.println("Исходный список\n" + printList(list, " "));
        System.out.println("Полученный список\n" + printList(newReverseList(list), " "));
        reverseList(list);
        System.out.println("Преобразованный исходный список\n" + printList(list, " "));
    }

    // Получает LinkedList и возвращает его содержимое в виде строки
    public static String printList(LinkedList<Character> lst, String separ) {
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < lst.size(); i++) {
            res.append(lst.get(i) + separ);
        }
        return res.toString();
    }

    // Принмает LinkedList, возвращает новый LinkedList - зеркальное отображение исходного
    public static LinkedList<Character> newReverseList(LinkedList<Character> masterList) {
        LinkedList<Character> newList = new LinkedList<>();

        for(int i = 0; i < masterList.size(); i++) {
            newList.add(masterList.get(masterList.size() - 1 - i));
        }

        return newList;
    }

    // Принимает LinkedList и возвращает его же, но перевёрнутым
    public static void reverseList(LinkedList<Character> masterList){
        for(int i = 0; i < masterList.size(); i++) {
            masterList.add(0 + i, masterList.get(masterList.size() - 1)); 
            masterList.remove(masterList.size() - 1);                                   
         }
         
    }

}
