package MetodyGeneryczne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Figura figura1 = new Kolo();
        Figura figura2 = new Kwadrat();

        List<Figura> listaFigur = new ArrayList<Figura>();
        listaFigur.add(figura1);
        listaFigur.add(figura2);
        Figura[] figury = new Figura[50];
     //   Edytor.wypisz(listaFigur);
        System.out.println("--------------------------------");
        Edytor.wypisz2(listaFigur);
        Float[] fl = new Float[50];
        Integer[] in = new Integer[50];
        Number[] num = new Number[50];

        Collection<Number> cn = new ArrayList<Number>();

        Edytor.przepisTabliceDoKolekcji(fl, cn);
        Edytor.przepisTabliceDoKolekcji(in, cn);
        Edytor.przepisTabliceDoKolekcji(num, cn);
       // Edytor.przepisTabliceDoKolekcji(figury, cn);
    }
}

class Edytor{
    public static void wypisz(List<? extends Figura> lista){
    for(Figura figura : lista ){

        System.out.println(figura.getNazwa());
    }

    lista.add(null);
        System.out.println("");


        for(Figura figura : lista ){
            if(figura == null){
                System.out.println("null");
                break;
            }
            System.out.println(figura.getNazwa());
        }
    }

    public static <T extends Figura>void wypisz2(List<T> lista){
        for(Figura figura : lista ){

            System.out.println(figura.getNazwa());
        }


        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kwadrat());
        lista.add(null);
        System.out.println("");


        for(T figura : lista ){
            if(figura == null){
                System.out.println("null");
                break;
            }
            System.out.println(figura.getNazwa());
        }
    }

    public static <Type> void przepisTabliceDoKolekcji(Type[] tab, Collection<Type> c){

        for(Type o :   tab ){
            c.add(o);

        }


    }

}

class Figura<K>{
    K lala;
    String nazwa = "";
    public String getNazwa(){
        return nazwa;
    }
}

class Kolo extends Figura{

    public Kolo(){
        super.nazwa = "Kolo";
    }
}


class Kwadrat extends Figura{

    public Kwadrat(){
        super.nazwa = "Kwadrat";
    }
}