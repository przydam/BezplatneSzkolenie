package HashCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {


        Element a = new Element(47);
        Element b = new Element(15);
        Element c = new Element(5);
        c = null;
        Object d = new Object();
        d = 5;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(a.hashCode()%32);
        System.out.println(b.hashCode()%32);
        //System.out.println("abc".hashCode());
      //  System.out.println("abc".hashCode());
      //  System.out.println("abcc".hashCode());
        long mili = 0;
        long totalMili = 0;

        Set<Element> set = new TreeSet<Element>(
                new Comparator<Element>() {
                    @Override
                    public int compare(Element o1, Element o2) {
                        String opisO1 = o1.getOpis();
                        String opisO2 = o2.getOpis();
                        return opisO1.compareTo(opisO2);

                    }
                }
        );

        set.add(new Element(5, "opis 1"));
        set.add(new Element(3123, "opis 2"));
        set.add(new Element(321, "opis 3"));
        /*
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("informatyka.txt")));
            mili = System.currentTimeMillis();

            while(scanner.hasNext()){
                set.add(scanner.next());
            }



            totalMili = System.currentTimeMillis() - mili;

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        Iterator<Element> iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().wartosc);
        }
       // System.out.println("Czas wykonania: " + totalMili);
        System.out.println("Wczytanych słów: " +set.size());






    }
}
class Element implements Comparable{
    public int wartosc;
    public String opis;

    public Element(int wartosc){

        this.wartosc = wartosc;
    }

    public Element(int wartosc, String opis){

        this(wartosc);
        this.opis = opis;
    }

    public String getOpis(){
        return this.opis;
    }


    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
      if(object == null || this.getClass() != object.getClass()){
          return false;
      }


        return this.wartosc == ((Element)object).wartosc;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 14* hash + this.wartosc;
        return hash;

    }

    @Override
    public int compareTo(Object o) {

        return wartosc - ((Element)o).wartosc;
    }
}