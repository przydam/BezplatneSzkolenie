package Map;


import com.sun.xml.internal.bind.v2.model.core.ID;

import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /*
        *
        * klucz - wartosc1
        * klucz - wartosc2
        *
         */
       // TreeMap<Integer, Pracownik> mapa = new TreeMap<>();   //TreeMap - uporzadkowanie
        LinkedHashMap<Integer, Pracownik> mapa = new LinkedHashMap<>();
        Pracownik[] pracownicy = {
                new Pracownik("Agnieszka"),
                new Pracownik("Aga"),
                new Pracownik("Damian"),
                new Pracownik("Michał"),
                new Pracownik("Agnieszka"),
                new Pracownik("Aga"),
                new Pracownik("Damian"),
                new Pracownik("Michał"),
                new Pracownik("Agnieszka"),
                new Pracownik("Aga"),
                new Pracownik("Damian"),
                new Pracownik("Michał"),
                new Pracownik("Agnieszka"),
                new Pracownik("Aga"),
                new Pracownik("Damian"),
                new Pracownik("Michał"),
                new Pracownik("Agnieszka"),
                new Pracownik("Aga"),
                new Pracownik("Damian"),
                new Pracownik("Michał")
        };

        for(Pracownik pracownik: pracownicy){
            mapa.put(pracownik.getID(),pracownik);
            }
        System.out.println(mapa);

        mapa.remove(3);


        mapa.put(4,new Pracownik("Asia"));
        mapa.put(3,new Pracownik("Patryk"));



        mapa.entrySet();
        System.out.println(mapa);
        for(Map.Entry<Integer,Pracownik> wpis: mapa.entrySet() ){
            // System.out.println("ID " + wpis.getKey()+ " Imie: " + wpis.getValue().getImie());




                System.out.println("ID Pracownika "+ wpis.getKey());
                System.out.println("Imie " + wpis.getValue().getImie());


        }
        System.out.println("---------------------------------------------------------------");
        TreeMap<Integer,Pracownik> mapaPosotrowana = new TreeMap<Integer, Pracownik>(mapa);

        Map<Integer,Pracownik> subMapa = mapaPosotrowana.subMap(0,4);

        for(Map.Entry<Integer,Pracownik> wpis: subMapa.entrySet() ){
           // System.out.println("ID " + wpis.getKey()+ " Imie: " + wpis.getValue().getImie());



            if(subMapa.isEmpty()){
                System.out.println("PUSTO");
            }else{
                System.out.println("ID Pracownika "+ wpis.getKey());
                System.out.println("Imie " + wpis.getValue().getImie());
            }

        }

        Map<Date, Event> exampleMap;









    }
}

class Pracownik{
    public static int i= 0 ;
    private int ID = 0;
    String imie;


    public Pracownik(){
        i++;
        ID = i;
            }
    public Pracownik(String imie){
        this();
        this.imie = imie;

    }

    public int getID(){
        return this.ID;
     }

    public String getImie() {
        return this.imie;
    }

    @Override
    public String toString() {
        return this.imie;
    }
}