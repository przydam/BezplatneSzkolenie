package com.company;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import static com.company.ExerciseFile1.WypiszSciezki;


public class ExerciseFile1 {

    public static void main(String[] args) {

       //      File katalog = new File("Katalog");
      //  katalog.mkdir();

        File katalog = new File("Katalog"+File.separator+"java"+File.separator+"Mysql");
        katalog.mkdirs();


        File file2 = new File("Katalog"+File.separator+"java"+File.separator+"Mysql","exercise1.txt");



        if(!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        File file = new File("test.exe");

        if(!file.exists()){


            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("Can Write: " + file.canWrite());
        System.out.println("Can Execute: " + file.canExecute());
        System.out.println("Can Read: " + file.canRead());
        System.out.println("Is Hidden: " + file.isHidden());
        System.out.println("Is File: " + file.isFile());
        System.out.println("Last Change: " + new Date(file.lastModified()));
        System.out.println("File Lenght" + file.length());
        System.out.println("File Path " + file.getPath());

        //dosłowna ścieżka
        System.out.println("File Absolute Path " + file.getAbsolutePath());

        //zawsze prawdziwa
        try {
            System.out.println("File Canonical Path " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }




        WypiszSciezki(new File(System.getProperty("user.dir")));




        file.delete();


        String property = System.getProperty("user.dir");
        String property1 = System.getProperty("user.home");
        System.out.println("property " + property + "\r\n" + property1);








    }

    public static void WypiszSciezki(File nazwaSciezki){
        String[] nazwyPlikowIKatalogow = nazwaSciezki.list();
        System.out.println(nazwaSciezki.getPath());
        for (String nazwa:nazwyPlikowIKatalogow) {

            File p = new File(nazwaSciezki.getPath(), nazwa);
            System.out.println(p.getPath());

            if(p.isDirectory()){
               // System.out.println(p.getPath());
                WypiszSciezki(new File (p.getPath()));
            }
            // tylko pliki
            /*
            if(p.isFile()){
                System.out.println(p.getPath());
            }
            */

        }

    }

}
