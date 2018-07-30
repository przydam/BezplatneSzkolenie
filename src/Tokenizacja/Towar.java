package Tokenizacja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar extends Date {

    private double cena;
    private String nazwa;
    private Date dataWydania;

    public Towar(){
        this.cena = 0.0;
        this.dataWydania = new GregorianCalendar().getTime();
        this.nazwa = " ";
    }

    public Towar(double cena, String nazwa){

        this();
        this.cena = cena;
        this.nazwa = nazwa;
    }
    public Towar(double cena, String nazwa, int rok, int miesiac, int dzien){

        this(cena, nazwa);
        GregorianCalendar kalendarz = new GregorianCalendar(rok, miesiac+1, dzien);
        this.dataWydania = kalendarz.getTime();

    }

    public double getCena() {
        return this.cena;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public Date getDataWydania() {
        return this.dataWydania;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setDataWydania(Date dataWydania) {
        this.dataWydania = dataWydania;
    }

    @Override
    public String toString() {

        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        return this.cena + "zł nazwa "
                + this.nazwa+ " Czas: "
                + kalendarz.get(Calendar.YEAR)
                + "/"
                +(kalendarz.get(Calendar.MONTH)+1)
                + "/"
                +kalendarz.get(Calendar.DAY_OF_MONTH);
    }


    public static void zapiszDoPliku(Towar[] towar, PrintWriter outS){

        outS.println(towar.length);
        GregorianCalendar kalendarz = new GregorianCalendar();

        for (Towar towary:towar) {
            kalendarz.setTime(towary.getDataWydania());
            outS.println(
                    towary.getCena()
                    + ";"
                    + towary.getNazwa()
                    + ";"
                    + kalendarz.get(Calendar.YEAR)
                    + ";"
                    +((kalendarz.get(Calendar.MONTH))+1)
                    + ";"
                    +kalendarz.get(Calendar.DAY_OF_MONTH)
            );

        }




    }



    public static Towar[] odczytZPliku(BufferedReader inS) throws IOException {

        int dlugosc = Integer.parseInt(inS.readLine());


        Towar[] towar = new Towar[dlugosc];
        for(int i =0; i<dlugosc; i++){

            String linia = inS.readLine();
           // System.out.println(linia);
            StringTokenizer tokeny = new StringTokenizer(linia, ";");

            //System.out.println( tokeny.nextToken());

            double cena = Double.parseDouble(tokeny.nextToken());
            String nazwa = tokeny.nextToken();
            int rok = Integer.parseInt(tokeny.nextToken());
            int miesiac = Integer.parseInt(tokeny.nextToken());
            int dzien = Integer.parseInt(tokeny.nextToken());


            towar[i] = new Towar(cena, nazwa, rok, miesiac, dzien);

        }
    return towar;

    }

}
