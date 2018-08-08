package Synchonizacja;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MaszynaZmieniajacaSkrzynki implements Runnable{
   private Skrzynka skrzynka;
   private Lock lock;
   private Condition oczekianie;
    MaszynaZmieniajacaSkrzynki(Skrzynka skrzynka, Lock lock, Condition oczekiwanie){
        this.skrzynka = skrzynka;
        this.lock = lock;
        this.oczekianie = oczekiwanie;
    }
    @Override
    public void run() {
        lock.lock();

        try{
        synchronized (skrzynka){
            System.out.println(Thread.currentThread().getName()+" Zaczynam sie przygotowywać do zmiany skrzynki");
            while(true){
                while (!skrzynka.jestPelna()){

                    try{
                        System.out.println(Thread.currentThread().getName()+" Informuję, że skończyłem zamieniać");
                      //  skrzynka.wait();
                        oczekianie.await();
                        System.out.println(Thread.currentThread().getName()+" powróciłem do zamiany ");
                    }catch(InterruptedException ex){
                        System.out.println(ex.getMessage());
                    }

                }
            skrzynka.getIloscButelek();
            skrzynka.zamiana();
            skrzynka.getIloscButelek();

            //informuje inne watki ze juz skonczyl i moga one dalej dzialac na jednym obiekcie
           // skrzynka.notifyAll();
                oczekianie.signalAll();
            }

        }

    }finally {
        lock.unlock();
    }
    }
}
