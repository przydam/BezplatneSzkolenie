package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> listaPowiazana = new LinkedList<String>();

        for(int i =0; i< 10; i++){
            listaPowiazana.add("lalal "+ i );

        }


        Iterator<String> iter = listaPowiazana.iterator();

        iter.next();
        iter.next();
        iter.remove();

        ListIterator<String> iterL =listaPowiazana.listIterator(listaPowiazana.size());
        while (iterL.hasPrevious()){
            System.out.println(iterL.previous());
            iterL.set("PODMIANA");
        }
       iterL =listaPowiazana.listIterator();
        iterL.add("NOWY");

        Main.wypiszElementListy(listaPowiazana);
        /*
        while(iter.hasNext()){
            iter.remove();
        }
        */
/*
        for(int i =0; i< listaPowiazana.size(); i++)
        {
            // zabija procesor
            // pobiera indeksy od poczatku do okreslonego obiektu
            System.out.println(listaPowiazana.get(i));

        }
        */

        ArrayList<LinkedList> listaList = new ArrayList<LinkedList>(8);
        LinkedList kubelek;

        for(int i = 0; i<listaList.size(); i++ ){
            kubelek = new LinkedList();
            listaList.add(kubelek);
        }







    }
    public static void wypiszElementListy(LinkedList<?> lista){


       // iterator - stacze sobie miedzy indeksami


        Iterator iteratorListy = lista.iterator();

        while(iteratorListy.hasNext())
        System.out.println(iteratorListy.next());

        System.out.println();
    }
}
