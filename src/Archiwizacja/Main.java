package Archiwizacja;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static final int BUFFOR = 1024;
    public static void main(String[] args) {

        String[] tab = new String[] {"nazwaPliku.txt", "dane.txt"};
        byte tmpData[] = new byte[BUFFOR];
        try{

            ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("nazwamojegozipa.zip"), BUFFOR));



            BufferedInputStream inS = new BufferedInputStream(new FileInputStream("inny.txt"), BUFFOR);
            zOutS.putNextEntry(new ZipEntry("inny.txt"));
            int counter;


            while((counter = inS.read(tmpData, 0, BUFFOR)) != -1){
            zOutS.write(tmpData,0, counter);

            }
            zOutS.closeEntry();
            inS.close();
            zOutS.close();


        }catch(IOException e){
            System.out.println(e.getMessage());
        }




    }
}
