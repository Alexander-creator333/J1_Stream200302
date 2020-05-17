package ru.gb.jtwo.c_lesson.online;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String[]>> map;
    public PhoneBook(){
        map = new HashMap<>();
    }
    public PhoneBook(String lastName, String phone, String eMail){
        this();
        this.add(lastName, phone,eMail);
    }

    public void add(String lastName, String phone, String eMail){
        String[] tmp = new String[2];
        tmp[0] = phone;
        tmp[1] = eMail;
        if(map.get(lastName)!=null){
            map.get(lastName).add(tmp);
        } else {
            ArrayList<String[]> list = new ArrayList<>();
            list.add(tmp);
            map.put(lastName, list);
        }
    }
    public ArrayList GetPhone(String lastName){
        ArrayList<String> tmp;
        if(map.get(lastName)!=null){
            tmp = new ArrayList<>();
            for (int i = 0; i < map.get(lastName).size(); i++) {
                tmp.add(map.get(lastName).get(i)[0]);
            }

        } else {
            tmp = null;
        }

        return tmp;
    }

    public ArrayList GetEmAIL(String lastName){
        ArrayList<String> tmp;
        if(map.get(lastName)!=null){
            tmp = new ArrayList<>();
            for (int i = 0; i < map.get(lastName).size(); i++) {
                tmp.add(map.get(lastName).get(i)[1]);
            }

        } else {
            tmp = null;
        }

        return tmp;
    }

}
