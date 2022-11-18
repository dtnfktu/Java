package noteBooks;

import java.io.FileWriter;
import java.util.HashSet;
import java.io.*;

public class JsonModule {
    // Упаковывает экземпляр класса NoteBook в строку JSON
    public static String convertToJson(NoteBook book){
        StringBuilder answer = new StringBuilder("{");
        answer.append("\"brand\":\"" + book.getBrandName() + "\",");
        answer.append("\"model\":\"" + book.getModelName() + "\",");
        answer.append("\"cpu\":\"" + book.getProcessor() + "\",");
        answer.append("\"ram\":" + book.getRAM() + ",");
        answer.append("\"hdd\":" + book.getHDD() + ",");
        answer.append("\"diagonal\":" + book.getDiagonal() + ",");
        answer.append("\"os\":\"" + book.getOs() + "\",");
        answer.append("\"quantity\":" + book.getQuantity() + "}");
        return answer.toString();
    }

    // Упаковывает HashSet в JSON-файл
    public static void writeToJson(HashSet<NoteBook> books, String fName){
        int counter = 0;
        try(FileWriter writer = new FileWriter(fName)){
            writer.write("[");
            for(NoteBook book : books){
                writer.write(convertToJson(book));
                if (++counter < books.size()) writer.write(",");
            }
            writer.write("]");
            writer.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
    }

        // Конвертирует строку JSON в множество ноутбуков HashSet<NoteBook>
        public static HashSet<NoteBook> parseJsonString(String jstr){
            // Сначала "чистим" от скобок
            String[] tmpStr = jstr.replace("[","").replace("]","").split("}");
            for(int i = 0; i < tmpStr.length; i++) {
                tmpStr[i] = tmpStr[i].replace(",{","").replace("{","");
            }
            HashSet<NoteBook> outSet = new HashSet<>();
            


            return outSet;
        }
}
