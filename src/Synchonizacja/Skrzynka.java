package Synchonizacja;

import java.util.ArrayList;

public class Skrzynka {
    private final int POJEMNOSC = 10;
    private ArrayList listaButelek =new ArrayList(POJEMNOSC);

    public synchronized boolean jestPelna(){
        if(listaButelek.size() == POJEMNOSC){
            return true;



        }
        return false;
    }

    public synchronized void dodaj(Butelka butelka){
    listaButelek.add(butelka);

    }
    public synchronized void zamiana(){
        System.out.println(Thread.currentThread().getName()+ "Zamieniam skrzynki");
        listaButelek.clear();

    }


    public synchronized int getIloscButelek(){
        System.out.println(Thread.currentThread().getName()+ "Aktualnie w skrzynce jest: " + this.listaButelek.size());
        return this.listaButelek.size();
    }


}
