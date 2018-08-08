package Wielowatkowosc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

       // Runnable wypisanie = new WypisanieRunnable();

        Lock lock = new ReentrantLock();



        Thread watek = new Thread(new WypisanieRunnable(lock), "Watek 1");
        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");
        Thread watek3 = new Thread(new WypisanieRunnable(lock), "Watek 3");
        Thread watek4 = new Thread(new WypisanieRunnable(lock), "Watek 4");
        watek.start();
        /*
        //łączy wątki
        watek.join();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Wykonałem coś po zakończonym watku watek");
        */
        watek2.start();
        watek3.start();
        watek4.start();
/*
        Counter licznik  = new Counter();
        Thread watek3 = new Thread(new ConterRunnable(licznik, false), "Maleje");
        Thread watek4 = new Thread(new ConterRunnable(licznik, true), "Rośnie");

        watek3.start();
        try {
            watek.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        watek4.start();
        */
    }
}

class WypisanieRunnable implements Runnable{

    WypisanieRunnable(Lock lock){
    this.lock = lock;
    }

    static String[] msg = {"To", "jest", "synchronicznie", "wypisana", "wiadomość"};

    @Override
    public void run() {

    display(Thread.currentThread().getName());


    }

    public void display(String threadName) {

      //  synchronized (lock) {
            //nie pozwala wejśc do metody innemu wątkowi podcza wykonywania poniższego
            lock.lock();
            try{


            for (int i = 0; i < msg.length; i++) {
                System.out.println(threadName + ": " + msg[i]);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
           // }


        }finally{
                lock.unlock();
            }
    }
private Lock lock;

}


class Counter{

    public void increaseCounter(){

        counter++;
        System.out.println(Thread.currentThread().getName()+": "+ counter);

    }


    public void decreaseCounter(){
        counter --;
        System.out.println(Thread.currentThread().getName()+": "+ counter);

    }

    private int counter = 50;
}
class ConterRunnable implements Runnable{

    public ConterRunnable(Counter licznik, boolean increase){
        this.licznik = licznik;
        this.increase = increase;
    }
    @Override
    public void run() {
        synchronized (licznik) {
            for (int i = 0; i < 50; i++) {
                if (increase)
                    licznik.increaseCounter();
                else
                    licznik.decreaseCounter();


                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

            }


        }
    }
    boolean increase;
    Counter licznik;

}