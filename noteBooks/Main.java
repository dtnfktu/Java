package noteBooks;

import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        HashSet<NoteBook> noteBooksShop = new HashSet<>();              // каталог ноутбуков в магазине
        NoteBook nBook = new NoteBook("Acer", "Aspire");
        nBook.setProcessor("Intel Celeron 3025");
        nBook.setRAM(2048);
        nBook.setHDD(512);
        nBook.setDiagonal(15.5);
        nBook.setOS("Win 10");
        nBook.setReceipt(0);
        noteBooksShop.add(nBook);

        nBook = new NoteBook("Asus", "KX-10");
        nBook.setProcessor("AMD Ryzen 3");
        nBook.setRAM(1024);
        nBook.setHDD(512);
        nBook.setDiagonal(14);
        nBook.setOS("Win 11");
        nBook.setReceipt(0);
        noteBooksShop.add(nBook);


        //System.out.println(nBook.toString());

        //System.out.println(JsonModule.convertToJson(nBook));
        //JsonModule.writeToJson(noteBooksShop,"notebooks.json");
        System.out.println(JsonModule.parseJsonString(JsonModule.convertToJson(nBook)));
    }
}
