package Synchonizacja;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition oczekiwanie = lock.newCondition();
        Skrzynka skrzynka= new Skrzynka();
        MaszynaProdukujacaButelki maszyna1 = new MaszynaProdukujacaButelki(skrzynka, lock, oczekiwanie);
        MaszynaZmieniajacaSkrzynki maszyna2 = new MaszynaZmieniajacaSkrzynki(skrzynka, lock, oczekiwanie);
        Thread produkcja = new Thread(maszyna1, "producent");
        Thread zmieniacz = new Thread(maszyna2, "zmieniacz");

        produkcja.start();
        zmieniacz.start();

    }
}

