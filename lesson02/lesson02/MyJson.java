/* Дана json строка (сохранить в файл и читать из файла) (ЕСЛИ НЕ ПОЛУЧАЕТСЯ JSON, то сделайте получение через обычный текстовый файл!!!) 
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова", "оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. 
----------------------------------------------------------------------------------------------------------------------------------------------

Исполнение в двух вариантах: 
1 - json-строка конвертируется в двумерный массив строк. Каждая строка массива - запись о студенте.
минус такого подхода - ключи (имена полей) не учитываются, важна очередность
2 - json-строка конвертируется в массив Map. Здесь доступ к значению по ключу, очередность не имеет значения.
*/


import java.io.*;
import java.util.HashMap;
import java.io.FileWriter;

public class MyJson
{
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("bubble.log", false);

            String str = readFromFile("data.json");                     // Считываем json-строку из файла
//-------------- вариант 1 - парсинг в массив массивов строк ----------------------------------------------
            String[][] strArray = parseJsonString(str);                 // Переводим json-строку в двумерный массив строк

            String[] form = {"Студент ", " получил ", " по предмету "};   // Создаем шаблон выводимой фразы

            fw.append("Результат выполнения первого варианта:\n");
            for (int i = 0; i < strArray.length; i++) {
                StringBuilder ans = new StringBuilder("");
                for (int j = 0; j < form.length; j++) {
                    ans.append(form[j] + strArray[i][j]);
                }
                fw.append(ans + ".\n");
            }
//------------- вариант 2 - парсинг в массив Мар ----------------------------------------------------------
            HashMap<String, String>[] mapArr = parseJsonMap(str);
            fw.append("\nРезультат выполнения второго варианта:\n");
            for (int i = 0; i < mapArr.length; i++) {
                StringBuilder ans = new StringBuilder("");
                ans.append("Студент " + mapArr[i].get("фамилия"));
                ans.append(" получил " + mapArr[i].get("оценка"));
                ans.append(" по предмету " + mapArr[i].get("предмет") + ".");
                fw.append(ans + "\n");
            }
            fw.close();

        } catch(Exception e) {
            System.out.print("Error");
        }
    }

    // Конвертирует строку JSON в массив строк
    public static String[][] parseJsonString(String jstr){
        String[] tmpStr = jstr.replace("[","").replace("]","").split("}");
        for(int i = 0; i < tmpStr.length; i++) {
            tmpStr[i] = tmpStr[i].replace(",{","").replace("{","");
        }
        String[][] outStr = new String[tmpStr.length][3];
        for(int i = 0; i < tmpStr.length; i++) {
            String[] tmp = tmpStr[i].split(",");
            for(int j = 0; j < tmp.length; j++) {
                outStr[i][j] = tmp[j].split(":")[1].replace("\"","");
            }
        }
        return outStr;
    }

    // Считываем информацию из JSON-файла fileName и возвращаем строку
    public static String readFromFile(String fileName) {
        StringBuilder out = new StringBuilder("");
        try(FileReader reader = new FileReader(fileName))
        {
            int c;
            while((c = reader.read()) != -1){
                out.append((char) c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return out.toString();
    }

    // Конвертирует JSON-строку в массив HashMap
    public static HashMap<String,String>[] parseJsonMap(String jstr) {
        String[] tmpStr = jstr.replace("[","").replace("]","").split("}");

        for(int i = 0; i < tmpStr.length; i++) {
            tmpStr[i] = tmpStr[i].replace(",{","").replace("{","");
        }

        HashMap<String, String>[] out = new HashMap[tmpStr.length];
        for(int i = 0; i < tmpStr.length; i++) {
            String[] tmp = tmpStr[i].split(",");
            out[i] = new HashMap<>();
            for(int j = 0; j < tmp.length; j++) {
                String[] currentEl = tmp[j].replace("\"","").replace(" ","").split(":");
                //System.out.println(currentEl[0] + " - " + currentEl[1]);
                out[i].put(currentEl[0],currentEl[1]);
            }
        }
        return out;
    }
}