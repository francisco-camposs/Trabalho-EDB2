package br.com.francisco;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public static ArrayList<String> readCSV(String path){
        return readCSV(path, null);
    }

    public static ArrayList<String> readCSV(String path, String separator){

        ArrayList<String> arrayList = new ArrayList<>();
        Scanner file;
        try {
           file = new Scanner(new FileReader(path));
        } catch (FileNotFoundException ex){
            System.out.println("File not found");
            return null;
        }

        String aux;

        while (file.hasNextLine()){
            aux = file.nextLine();
            arrayList.add(aux);
        }

        return arrayList;
    }
}
