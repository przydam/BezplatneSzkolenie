package Kolekcje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        Collection b;


        ArrayList<String> a = new ArrayList<String>();
        //b.add();

        Map c;

        a.add(new String("lala"));
        a.add(new String("lala"));
        a.add(new String("lala"));
        a.add(new String("lala"));
        a.add(new String("lala"));


        //a.add(new Integer(4));

        for(int i =0; i<a.size(); i++){


            for(String stringus : a){
                System.out.println(stringus);
            }
            System.out.println((String)a.get(i));
            Zwykla<String> nazwaZmiennej = new Zwykla<>();
            nazwaZmiennej.nadajWartosc("Cosik");
            System.out.println(nazwaZmiennej.zwroc());
        }


    }

    */

        List<String> listaStringow = new ArrayList<String>();
      //  List<SuperClass> listaClass = new ArrayList<SuperClass>();
        List<SubClass> listaClass = new ArrayList<SubClass>();
       // listaClass.add(new SubClass());
        listaClass.add(new SubClass());
        SuperClass.tester(listaClass);
       // SuperClass.tester(listaStringow);


        /*  źle
        ArrayList<String> listS = new ArrayList<String>();
        ArrayList<Object> listaO = listS;

        listaO.add(new Integer(4));
        String a = listaO.get(0);
        */
}
static class SuperClass{
    static void tester(List<? extends SuperClass> lista){

        /*
        *
        * ? - wildcard - znak wieloznacznosci
        * ? extends JakaśClassa - znak wieloznacznosi jest ograniczony klasa JakaśClassa bounded wildcard
        *
         */

    }
    }

private static class SubClass extends SuperClass{
    }
}



class Zwykla<COKOLWIEK>{
    COKOLWIEK nazwaZmiennejTypuCokolwiek;

    public void nadajWartosc(COKOLWIEK wartosc){
        this.nazwaZmiennejTypuCokolwiek = wartosc;
    }


    public COKOLWIEK zwroc(){
        return this.nazwaZmiennejTypuCokolwiek;
    }

}