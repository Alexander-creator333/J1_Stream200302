package ru.geekbrains.java_one.lesson_f.online;

import java.io.*;
import java.util.Scanner;

/*
1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
4. ** Написать метод, проверяющий, есть ли указанное слово в папке
 */

public class FileReaderWriter {
    private static final Scanner SCANNER = new Scanner(System.in);

    //Метод создающий файл заданного имени и заданной длинны.
    //Вы говорили, что читать с консоли и писать в консоль внутри метода плохо,
    // но я решил в этот раз сделать так :)
    public static void CreateFile(String fName, int fLength) throws IOException {
        String cStr="";
        System.out.println("Введите теккст файла, не менее "+fLength+" знаков: ");
        while( cStr.length() < fLength ) {
            cStr = cStr + SCANNER.nextLine() + "\r\n";
        }
        PrintStream ps = new PrintStream(new FileOutputStream(fName));
        ps.println(cStr);
        ps.close();
    }

    //2. Соединяем пару файлов
    public static int ConcateFiles(String fName1, String fName2, String fName3) throws IOException {
        int fLen=0;//Длина полученного файла
        //Открываем файл для записи
        OutputStream out;
        out = new FileOutputStream("file3.txt");
        //Пишем в него первый файл
        FileInputStream fis = new FileInputStream("file1.txt");
        int b;
        while ((b = fis.read()) != -1) {
            out.write(b);
            fLen++;
        }
        fis.close();//Закрываем первый, открываем второй файл и пишем его
        FileInputStream fis1 = new FileInputStream("file2.txt");
        while ((b = fis1.read()) != -1) {
            out.write(b);
            fLen++;
        }
        fis1.close();
        //Закрываем полученный файл
        out.flush();
        out.close();
        return fLen;
    }

    //3. Метод ищет строку в файле
    public static int StringInFile(String cStr, String fName) throws IOException {
        int fLen=0;
        int pPos=0;
        FileInputStream fis = new FileInputStream(fName);
        int b;
        while ((b = fis.read()) != -1) {
            if((char)b == cStr.charAt(pPos)){
                pPos++;
            } else {
                pPos=0;
            }
            if(pPos == cStr.length())
            {
                return fLen;
            }
            fLen++;
        }
        fis.close();
        return -1;
    }

    public static String StringInDirectory(String cStr, String dName) throws IOException {
        File f = new File(dName);
        int sInd=0;
        String[] DirList = f.list();
        for (int i = 0; i < DirList.length; i++)
        {
            File f1 = new File(dName+DirList[i]);
            if (!f1.isDirectory())
            {
                sInd = StringInFile(cStr, dName+DirList[i]);
                if(sInd != -1){
                    return DirList[i]+" search position= "+String.valueOf(sInd);
                }
            }
            else
            {
                //is Directory...
                //...add code for sub-dirs
            }
        }
        return "So sorry...";
    }

    public static void main(String[] args) {
        //1. Заполняем первый файл
        System.out.println("Заполняем файл file1.txt.");
        try {
            CreateFile("file1.txt",55);
        } catch (IOException e) {
            System.out.print("Ошибка при работе с файлом >> "+e.toString());
        }
        //1. Заполняем второй файл
        System.out.println("Заполняем файл file2.txt.");
        try {
            CreateFile("file2.txt",57);
        } catch (IOException e) {
            System.out.print("Ошибка при работе с файлом >> "+e.toString());
        }
        //2. Делаем общий файл
        System.out.println("Заполняем третий файл file3.txt, слиянием первых двух.");
        try {
            System.out.println("Получен файл длинной: "+ConcateFiles("file1.txt","file2.txt", "file3.txt"));
        } catch (IOException e) {
            System.out.print("Ошибка при работе с файлом >> "+e.toString());
        }
        //3. Ищем слово test в полученном файле
        System.out.println("Ищем слово test в полученном файле - file3.txt");
        try {
            int sInd = StringInFile("test","file3.txt");
            if( sInd == -1){
                System.out.println("Тестовая строка не найдена");
            } else{
                System.out.println("Тестовая строка найдена в " + sInd + " позиции.");
            }
        } catch (IOException e) {
            System.out.print("Ошибка при работе с файлом >> "+e.toString());
        }
        //4. Ищем слово в папке
        System.out.println("Ищем слово test в директории - C:\\333\\var\\java\\J1_Stream200302");
        try {
                System.out.println("Тестовая строка найдена в: " + StringInDirectory("test","C:\\333\\var\\java\\J1_Stream200302\\"));

        } catch (IOException e) {
            System.out.print("Ошибка при работе с файлом >> "+e.toString());
        }
    }
}
