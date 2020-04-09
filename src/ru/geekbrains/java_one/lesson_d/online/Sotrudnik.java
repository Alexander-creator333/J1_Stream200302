package ru.geekbrains.java_one.lesson_d.online;

public class Sotrudnik {
    private String familySotrudnika;
    private int zarplataSotrudnika;
    private int ageSotrudnika;
    private String dolzhnostSotrudnika;
    private int tableNumber;
    //***. Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер
    public static int lastTableNumber;

    public Sotrudnik() {
        tableNumber = lastTableNumber;
        lastTableNumber++;
        this.familySotrudnika = "Имя не определено";
        this.zarplataSotrudnika = 0;
        this.ageSotrudnika = 0;
        this.dolzhnostSotrudnika = "Должность не определена";
    }

    public Sotrudnik(String familySotrudnika, int zarplataSotrudnika, int ageSotrudnika, String dolzhnostSotrudnika) {
        //this();
        tableNumber = lastTableNumber;
        lastTableNumber++;
        this.familySotrudnika = familySotrudnika;
        this.zarplataSotrudnika = zarplataSotrudnika;
        this.ageSotrudnika = ageSotrudnika;
        this.dolzhnostSotrudnika = dolzhnostSotrudnika;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getFamilySotrudnika() {
        return familySotrudnika;
    }

    public int getZarplataSotrudnika() {
        return zarplataSotrudnika;
    }
    public void setZarplataSotrudnika(int zarplataSotrudnika) {
        this.zarplataSotrudnika = zarplataSotrudnika;
    }

    public int getAgeSotrudnika() {
        return ageSotrudnika;
    }

    public String getDolzhnostSotrudnika() {
        return dolzhnostSotrudnika;
    }
}
