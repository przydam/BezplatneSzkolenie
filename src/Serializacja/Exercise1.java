package Serializacja;



import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Exercise1 {


    public static void main(String[] args) {
        Towar[] towary = new Towar[5];

        towary[0] = new Towar(10.0,"PASCAL");
        towary[1] = new Towar(30.0, "JAVA");
        towary[2] = new Towar(20.0, "PHP");
        towary[3] = new Towar(10.0, "MySQL", 2018, 10, 1);
        towary[4] = new Towar(11.0, "SQL", 2019, 12, 11);


        try {
            ObjectOutputStream outS = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("BazaSerializacja.txt")));
            outS.writeObject(towary);

            outS.close();
            
            
            ObjectInputStream inS = new ObjectInputStream(new GZIPInputStream(new FileInputStream("BazaSerializacja.txt")));
            Towar[] a = (Towar[])inS.readObject();
            inS.close();

            for(int i = 0; i < a.length ; i++){
                System.out.println(a[i].getNazwa());
            }

            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }

    }


}