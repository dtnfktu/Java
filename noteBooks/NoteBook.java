package noteBooks;

public class NoteBook {
    private String brand = "";               // Название брэнда
    private String model = "";               // Название модели
    private String processor = "";           // процессор
    private int ramGb = 0;                   // ОЗУ в гигабайтах
    private int hddGb = 0;                   // Объём жесткого диска в гигабайтах
    private double diagonal = 0.0;           // Диагональ монитора в дюймах
    private String oS = "";                  // Операционная система
    private int quantity = 0;                // Количество в наличии

    // конструктор экземпляра класса Ноутбук - брэнд + модель
    NoteBook(String brandName, String model) {
        this.brand = brandName;
        this.model = model;
    }

    // ----------------- Геттеры - возвращают значения переменных экземпляра класса ------------------------------------------

    // Возвращает название ноутбука
    public String getBrandName(){
        return brand;
    }

    // Возвращает модель ноутбука
    public String getModelName(){
        return model;
    }

    // Возвращает процессор
    public String getProcessor(){
        return processor;
    }

    // Возвращает ОЗУ
    public int getRAM(){
        return ramGb;
    }

    // Возвращает емкость ЖД
    public int getHDD(){
        return hddGb;
    }

    // Возвращает диагональ монитора
    public double getDiagonal(){
        return diagonal;
    }

    // Возвращает установленную ОС
    public String getOs(){
        return oS;
    }

    // Возвращает количество ноутбуков данной модели в магазине
    public int getQuantity(){
        return quantity;
    }

    // --------------------- Сеттеры - устанавливают значения переменных экземпляра класса ---------------------------------------------------

    // Устанавливает название брэнда
    public void setBrand(String newName){
        this.brand = newName;
    }

    // Устанавливает название модели экземпляра класса
    public void setModel(String modelName){
        this.model = modelName;
    }

    // Устанавливает название процессора
    public void setProcessor(String procName){
        this.processor = procName;
    }

    // Устанавливает размер ОЗУ
    public void setRAM(int capacity){
        this.ramGb = capacity;
    }

    // Устанавливает объем ЖД
    public void setHDD(int capacity){
        this.hddGb = capacity;
    }

    // Устанавливает диагноаль монитора
    public void setDiagonal(double inches){
        this.diagonal = inches;
    }

    // Задаёт установленную ОС
    public void setOS(String nameOS){
        this.oS = nameOS;
    }

    // Поступление ноутбуков данной модели - количество
    public void setReceipt(int rec) {
        this.quantity += rec;
    }

    // Продажа - количество
    public void setSale(int rec) {
        if (rec <= this.quantity) {         // Если количество проданных
            this.quantity -= rec;           // не превышает количество в наличии
        } else {
            this.quantity = 0;              // иначе обнуляем - продали всё,что было
        }
    }

    // -------------------------- другие методы класса -------------------------------------------------------------
    // Вывод информации о ноутбуке в виде строки
    public String toString(){
        StringBuilder outStr = new StringBuilder("");

        outStr.append(brand + " " + model + " / ");
        outStr.append(diagonal + "' / ");
        outStr.append("CPU: " + processor + " / ");
        outStr.append("RAM: " + ramGb + " / ");
        outStr.append("HDD: " + hddGb + " / ");
        outStr.append(oS + " (" + quantity + ")");
        return outStr.toString();
    }

}
