package Synchonizacja;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MaszynaProdukujacaButelki implements Runnable{
    private Condition oczekianie;
    private Lock lock;
    private Skrzynka skrzynka;
   private int i=0;


    MaszynaProdukujacaButelki(Skrzynka skrzynka, Lock lock, Condition oczekiwanie){
    this.skrzynka = skrzynka;
        this.lock = lock;
        this.oczekianie = oczekiwanie;
    }
    @Override
    public void run() {

        lock.lock();

        try{



        synchronized (skrzynka){
            System.out.println(Thread.currentThread().getName()+" Zaczynam produkować butelki");
            while(true){

                while(skrzynka.jestPelna()){
                    try {
                        System.out.println(Thread.currentThread().getName()+" Informuję, że trzeba wymienić skrzynkę, Skrzynka pełna");
                       // skrzynka.wait();
                        oczekianie.await();
                        System.out.println(Thread.currentThread().getName()+" Powróciłem do produkcji");
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            skrzynka.dodaj(new Butelka());
                System.out.println(Thread.currentThread().getName()+" Wyprodukowałem buteleczke nr"+ ++i);

                //skrzynka.notifyAll();
                oczekianie.signalAll();
            }


        }
        }finally {
            lock.unlock();
        }
    }
}
