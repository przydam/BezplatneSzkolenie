package Serializacja;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Towar implements Serializable {
    public static final int DLUGOSC_NAZWY = 30;
    public static final int DLUGOSC_REKORDU = (Character.SIZE * DLUGOSC_NAZWY + Double.SIZE + 3 * Integer.SIZE)/8;
    private double cena; // 8 bajtow
    private String nazwa; //60 bajtow ( DLUGOSC_NAZWY  * 2)
    private Date dataWydania; //4 + 4 + 4 = 12  razem 80 bajtow
    private transient String haslo = "tajne";



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
    public String getHaslo() {
        return this.haslo;
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

    private void readObject(ObjectInputStream inS) throws IOException, ClassNotFoundException{
        inS.defaultReadObject();
        System.out.println("Wywołuje się z metody readObject");
        if(haslo != null)
        if(!haslo.equals("tajne")){
           throw new IOException("Dane są nieprawidłowe");


        }

    }


    private void writeObject(ObjectOutputStream outS) throws IOException{
        outS.defaultWriteObject();
        System.out.println("Wywołuje się z metody writeObject");

    }


}
