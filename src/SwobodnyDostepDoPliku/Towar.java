package SwobodnyDostepDoPliku;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar extends Date {
    public static final int DLUGOSC_NAZWY = 30;
    public static final int DLUGOSC_REKORDU = (Character.SIZE * DLUGOSC_NAZWY + Double.SIZE + 3 * Integer.SIZE)/8;
    private double cena; // 8 bajtow
    private String nazwa; //60 bajtow ( DLUGOSC_NAZWY  * 2)
    private Date dataWydania; //4 + 4 + 4 = 12  razem 80 bajtow

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


    public static void zapiszDoPliku(Towar[] towar, DataOutput outS){



        for (Towar towary:towar) {
            try {
                towary.zapiszDane(outS);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }




    }



    public static Towar[] odczytZPliku(RandomAccessFile RAF) throws IOException {

        int ilRekordow = (int) RAF.length()/DLUGOSC_REKORDU;



        Towar[] towar = new Towar[ilRekordow];
        for(int i =0; i<ilRekordow; i++){


            towar[i] = new Towar();
            towar[i].czytajDane(RAF);
        }
        return towar;

    }


    public void zapiszDane(DataOutput outS) throws IOException {

        outS.writeDouble(this.cena);
        StringBuffer stringBuffer = new StringBuffer(DLUGOSC_NAZWY);
        stringBuffer.append(this.nazwa);
        stringBuffer.setLength(DLUGOSC_NAZWY);
        outS.writeChars(stringBuffer.toString());

        GregorianCalendar kalendarz = new GregorianCalendar();
        kalendarz.setTime(this.dataWydania);
        outS.writeInt(kalendarz.get(Calendar.YEAR));
        outS.writeInt(kalendarz.get((Calendar.MONTH)+1));
        outS.writeInt(kalendarz.get(Calendar.DAY_OF_MONTH));
    }
    public void czytajDane(DataInput inS) throws IOException {

        this.cena = inS.readDouble();
        StringBuffer stringB = new StringBuffer(Towar.DLUGOSC_NAZWY);

        for(int i = 0; i < Towar.DLUGOSC_NAZWY; i++){
            char tCh = inS.readChar();

            if(tCh != '\0'){
                stringB.append(tCh);
            }

        }

        this.nazwa = stringB.toString();

                int rok = inS.readInt();
                int m = inS.readInt();
                int d =  inS.readInt();
                GregorianCalendar kalendarz = new GregorianCalendar(rok, m-1, d);
                this.dataWydania = kalendarz.getTime();
    }


    public void czytajRekord(RandomAccessFile RAF, int n) throws IOException, BrakRekordu{
        if(n <= RAF.length()/Towar.DLUGOSC_REKORDU){
            RAF.seek((n-1)* Towar.DLUGOSC_REKORDU);
            this.czytajDane(RAF);
        }else{
            throw new BrakRekordu("Niestety nie ma takiego rekordu");

        }


    }
}
