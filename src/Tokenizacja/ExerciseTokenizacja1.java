package Tokenizacja;

import java.io.*;

public class ExerciseTokenizacja1 {

    public static void main(String[] args) {
        Towar[] towary = new Towar[5];

        towary[0] = new Towar(10.0,"PASCAL");
        towary[1] = new Towar(30.0, "JAVA");
        towary[2] = new Towar(20.0, "PHP");
        towary[3] = new Towar(10.0, "MySQL", 2018, 10, 1);
        towary[4] = new Towar(11.0, "SQL", 2019, 12, 11);


        try {
            PrintWriter writer = new PrintWriter(new FileWriter("baza.txt"));
            Towar.zapiszDoPliku(towary,writer);

            writer.close();


            BufferedReader reader = new BufferedReader(new FileReader("baza.txt"));
            Towar[] towar2 = Towar.odczytZPliku(reader);

            for (Towar towary2:towar2) {

                System.out.println(towary2);

            }


            reader.close();
        } catch (IOException e) {
           System.out.println(e.getMessage());
        }

    }
}
