package LinkedList;

import java.util.*;

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


        Stack<String> stos = new Stack<String>();
        stos.push("lala1");
        stos.push("lala2");
        stos.push("lala3");
        stos.push("lala4");

        System.out.println(stos.pop());
        System.out.println(stos.pop());
        System.out.println(stos.pop());
        System.out.println(stos.pop());

        String nazwa = stos.peek();

        if (nazwa.equals("lala1")){
            System.out.println(stos.pop());
        }else{
            System.out.println("nie ma takiego na samej gorze");
        }


        //  System.out.println( stos.pop());
        Vector<String> wektor = new Vector<String>();
        wektor.add("lalala");
        wektor.get(0);

        HashMap a;

        Hashtable b;




    }
    public static void wypiszElementListy(LinkedList<?> lista){


       // iterator - stacze sobie miedzy indeksami


        Iterator iteratorListy = lista.iterator();

        while(iteratorListy.hasNext())
        System.out.println(iteratorListy.next());

        System.out.println();
    }
}
