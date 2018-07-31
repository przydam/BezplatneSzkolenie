package com.company;

import java.io.*;

public class ExerciseFile2 {

    public static void main(String[] args) {

      //  File file = new File("nazwaPliku.txt");
       // InputStream inS;
      //  OutputStream outS;

        //Reader reader;
        Writer writer = null;

        try {
       //     writer = new BufferedWriter(new FileWriter(file));


            writer.write("lala");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("dane.txt"));

            printWriter.println("1234");
           // printWriter.flush();


            printWriter.close();


            printWriter = new PrintWriter(new FileWriter("dane.txt"),true);

            printWriter.append("lalal");
            printWriter.println();
            printWriter.printf("On ma %d kg oraz %.2f %s wzrostu ", 50,165.462,"cm");


            printWriter.close();


            BufferedReader reader = new BufferedReader(new FileReader("dane.txt"));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("baza.txt"));

            System.out.println( reader.read());
            String tresc;
            while((tresc = reader.readLine()) != null){
                System.out.println(tresc);
                writer1.write(tresc);
                writer1.newLine();
            }


            reader.close();
            writer1.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ExerciseFile2 test1 = new ExerciseFile2();

        test(1,2,3,125,"lal",40);
    }

    static void test(Object... a){

        for (Object b:a) {
            System.out.println(b);
        }
    }
}
