package ru.gb.jtwo.c_lesson.online;

import java.util.HashMap;
import java.util.*;

public class WordPadJava {
    public static void main(String[] args) {
        String[] inText = {"Пять", "лет", "Сереже", "в", "январе", "Пока", "четыре", "пятый", "Но", "с", "ним", "играют", "во", "дворе",
        "И", "взрослые", "ребята", "А", "как", "на", "санках", "например", "Он", "с", "гор", "летает", "смело", "Сереже", "только", "буква",
        "р", "Немного", "портит", "дело"};

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < inText.length; i++) {
            if(map.get(inText[i])!=null){
                map.put(inText[i],map.get(inText[i])+1);
            } else {
                map.put(inText[i],1);
            }
        }
        //System.out.println(map.get("Jan"));
        //System.out.println(map.get("Jul"));
        System.out.println(map);

        PhoneBook MyEbook = new PhoneBook("Medvedev","79087229297","frons@en-mart.com");
        MyEbook.add("Medvedev","72342349294","a.medvedev@x5.ru");
        MyEbook.add("Medvedev","79037429267","al.med@x5.ru");
        MyEbook.add("Neizhmakov","79080000000","neiva@en-mart.com");
        MyEbook.add("Shkrobato","79081111111","shkan@en-mart.com");
        MyEbook.add("Novikov","79082222222","dmnov@en-mart.com");
        System.out.println("Phone");
        ArrayList<String> list1 = MyEbook.GetPhone("Medvedev");
        for (String s : list1) {
            System.out.println(s);
        }
        System.out.println("e-mail");
        ArrayList<String> list2 = MyEbook.GetEmAIL("Medvedev");
        System.out.println(list2);

    }
}
