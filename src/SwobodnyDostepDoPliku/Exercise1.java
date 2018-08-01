package SwobodnyDostepDoPliku;

import java.io.*;

public class Exercise1 {


    public static void main(String[] args) {
        SwobodnyDostepDoPliku.Towar[] towary = new SwobodnyDostepDoPliku.Towar[5];

        towary[0] = new SwobodnyDostepDoPliku.Towar(10.0,"PASCAL");
        towary[1] = new SwobodnyDostepDoPliku.Towar(30.0, "JAVA");
        towary[2] = new SwobodnyDostepDoPliku.Towar(20.0, "PHP");
        towary[3] = new SwobodnyDostepDoPliku.Towar(10.0, "MySQL", 2018, 10, 1);
        towary[4] = new SwobodnyDostepDoPliku.Towar(11.0, "SQL", 2019, 12, 11);


        try {
            /*
           DataOutputStream outS = new DataOutputStream( new FileOutputStream("nowy.txt"));
            outS.writeDouble(123.321);
            outS.close();

            DataInputStream inS = new DataInputStream(new FileInputStream("nowy.txt"));
            System.out.println(inS.readDouble());
            inS.close();
            */

            RandomAccessFile RAF = new RandomAccessFile("bazaTowarow.txt", "rw");
            /*
            RAF.writeDouble(123.123);
            RAF.writeDouble(43.43);
            RAF.writeChars("lalala");

            System.out.println(RAF.getFilePointer());

            RAF.seek(0);
            System.out.println(RAF.readDouble());
            RAF.seek(8);
            System.out.println(RAF.readDouble());
            RAF.seek(16);
            System.out.println(RAF.readChar());
            System.out.println(Double.SIZE/8 + Integer.SIZE/8);
   */


            towary[0].zapiszDane(RAF);
            Towar.zapiszDoPliku(towary, RAF);
            System.out.println(RAF.getFilePointer());
            RAF.seek(0);
            Towar [] towarki = Towar.odczytZPliku(RAF);

                    for(int i = 0; i < towarki.length; i++){
                        System.out.println(towarki[i].getCena());
                        System.out.println(towarki[i].getNazwa());
                        System.out.println(towarki[i].getDataWydania());
                        System.out.println("---------------------------------------------------");
                    }

            /*

            int n = 3;

            RAF.seek((n-1)*Towar.DLUGOSC_REKORDU);

            Towar a = new Towar();

            a.czytajDane(RAF);

            System.out.println(a);
            */


            try{
                Towar b = new Towar();
                b.czytajRekord(RAF, 123);
                System.out.println(b);
                System.out.println("lkalal");
            }catch(BrakRekordu e ){
                System.out.println(e.getMessage());
            }

            RAF.close();





        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
