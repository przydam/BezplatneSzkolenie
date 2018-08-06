package Archiwizacja;


import java.io.*;
import java.util.zip.*;


public class UnZip {

    public static void main(String[] args) {
        final int BUFFOR = 1024;
        byte tmpData[] = new byte[BUFFOR];
        File katalog = new File(System.getProperty("user.dir")+ File.separator+"nazwamojegozipa");
        ZipEntry wpis  = null;
        try{



        if(!katalog.exists()){
            katalog.mkdir();

        }


        ZipInputStream zInS = new ZipInputStream(new FileInputStream("nazwamojegozipa.zip"));
        zInS.getNextEntry();

        while((wpis = zInS.getNextEntry()) != null){
            wpis.getName();

            BufferedOutputStream fOutS = new BufferedOutputStream(new FileOutputStream(katalog+File.separator+wpis.getName()));

            int counter;

            while((counter = zInS.read(tmpData, 0 , BUFFOR)) != -1){
            fOutS.write(tmpData, 0 ,counter);
            }



            fOutS.close();
            zInS.closeEntry();
            }



        zInS.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
