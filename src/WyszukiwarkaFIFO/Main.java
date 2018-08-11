package WyszukiwarkaFIFO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Main {
    private static final File sciezkaGlowna = new File(System.getProperty("user.dir"));
    private static final String slowoSzukane = "źródło";
    public static void main(String[] args) {


        BlockingQueue<File> kolejkaBlokujaca = new ArrayBlockingQueue<File>(5);

        new Thread(new PoszukiwaczSciezek(kolejkaBlokujaca, sciezkaGlowna)).start();


        for(int i = 0; i<50; i++ ){
            new Thread(new PrzeszukiwacPliku(kolejkaBlokujaca, slowoSzukane)).start();

        }


    }
}

class PoszukiwaczSciezek implements Runnable{

    BlockingQueue<File> kolejka;
    File sciezkaGlowna;

    PoszukiwaczSciezek(BlockingQueue<File> kolejka, File sciezkaGlowna){
    this.kolejka = kolejka;
    this.sciezkaGlowna = sciezkaGlowna;
    }


    @Override
    public void run() {

        try {
            szukajSciezek(sciezkaGlowna);
            kolejka.put(new File("pusty"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void szukajSciezek(File sciezka){
        File[] sciezki = sciezka.listFiles();
        for(int i = 0; i<sciezki.length; i++){

            if(sciezki[i].isDirectory()){
                szukajSciezek(sciezki[i]);
            }else{
                try {
                    kolejka.put(sciezki[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class PrzeszukiwacPliku implements Runnable{
    BlockingQueue<File> kolejka;
    String slowoSzukane;
    PrzeszukiwacPliku(BlockingQueue<File> kolejka, String slowoSzukane){
        this.kolejka = kolejka;
        this.slowoSzukane = slowoSzukane;
    }
    @Override
    public void run() {
        boolean skonczone = false;
        while(!skonczone){
            File przeszukianyPlik = null;
            try {
                przeszukianyPlik = kolejka.take();
                if(przeszukianyPlik.equals(new File("pusty"))) {
                    skonczone = true;

                }
                else {
                    szukajSlowa(przeszukianyPlik);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        }

    public void szukajSlowa(File przeszukiwanyPlik){

        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(przeszukiwanyPlik)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int nrLinii = 0;

        while(scanner.hasNext()) {
            nrLinii++;
            if(scanner.nextLine().contains(slowoSzukane)) {

                System.out.println("szukane slowo znajduje sie w "+ przeszukiwanyPlik.getPath() + " w linii nr "+ nrLinii);
            }

        }
        scanner.close();


    }
}



