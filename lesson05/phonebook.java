// Реализовать структуру телефонной книги с помощью HashMap. Учесть, что у одного человека может быть несколько телефонных номеров

// Решение.
// Телефонный справочник представляет собой HashMap
// где ключ - имя контакта, значение - список (LinkedList) номеров телефонов данного контакта
// В задании требовалось реализовать структуру, она реализована (один из возможных вариантов)
// Для наглядности реализована функция добавления номера телефона и вывод телефонной книги.
// При добавлении: если контакт с заданным именем уже есть, то к нему добавляется новый номер, если нет - то добавляется контакт с номером

// Никак не разберусь с кодировкой. При вводе с консоли в Windows на кириллице отображается абракадабра, в Linux - проблем нет
// Поэтому лучше имена вводить латиницей (John, Paul, Mary etc)


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        HashMap<String,LinkedList<String>> phBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")){
            System.out.println("1 - Добавить в справочник");
            System.out.println("2 - Показать справочник");
            System.out.println("exit - для завершения работы");
            command = in.nextLine();
            if (command.equals("1")) {
                addAbonent(phBook);
            } else {
                printBoook(phBook);
            }
        }
        in.close();
    }
        
    // добавление телефонного номера - возвращает имя абонента
    public static void addAbonent(HashMap<String,LinkedList<String>> phoneBook){
        Scanner in = new Scanner(System.in);
        LinkedList<String> phones;
        System.out.print("Введите имя абонента : ");
        String name = in.nextLine();
        System.out.print("Введите телефонный номер : ");
        String phone = in.nextLine();
        //in.close();
        if (phoneBook.containsKey(name)) {          // Если в справочнике уже есть контакт с таким именем
            phones = phoneBook.get(name);           // то к списку его номеров добавляется
            phones.add(phone);                      // только что введенный
        } else {
            phones = new LinkedList<>();            // Новый контакт
            phones.add(phone);
            phoneBook.put(name, phones);
        }
        //return name;
    }

    // Вывод содержимого телефонного справочника
    public static void printBoook(HashMap<String,LinkedList<String>> book){
        for(String name : book.keySet()){
            System.out.println(name + ":");         // Имя контакта
            LinkedList<String> phones = book.get(name);
            for(String number : phones){
                System.out.println(" " + number);   // а здесь его номера телефонов
            }
        }
    }
}
