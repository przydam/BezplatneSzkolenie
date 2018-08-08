package Kropelka;

import org.omg.PortableServer.ThreadPolicyOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {

    public  Main(){
        this.setTitle("Kropelka Animacja");
        this.setBounds(250, 300, 300, 250);
        this.getContentPane().add(panelButton, BorderLayout.SOUTH);
        this.getContentPane().add(panelAnimacji);
        panelAnimacji.setBackground(Color.DARK_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = (JButton)panelButton.add(new JButton("Start"));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAnimation();

            }


        });


        JButton usunButton = (JButton)panelButton.add(new JButton("Usuń"));

        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAnimacji.stop();

            }


        });




    }



    private JPanel panelButton = new JPanel();
    private PanelAnimacji panelAnimacji = new PanelAnimacji();
    private void startAnimation() {


        panelAnimacji.addKropelka();
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }


class PanelAnimacji extends JPanel{
    Thread watek;
    ThreadGroup grupaWatkow = new ThreadGroup("Grupa Kropelek");





    public void addKropelka() {
        listaKropelek.add(new Kropelka());
        watek = new Thread(grupaWatkow, new KropelkaRunnable((Kropelka)listaKropelek.get(listaKropelek.size()-1)));

        watek.start();

        grupaWatkow.list();



    }


    public void stop(){

        //watek.interrupt();
        grupaWatkow.interrupt();

    }


    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);

    for(int i =0 ; i <listaKropelek.size(); i++){
        g.drawImage(Kropelka.GetImage(),((Kropelka)listaKropelek.get(i)).x, ((Kropelka)listaKropelek.get(i)).y, null) ;

    }


    }

    ArrayList listaKropelek = new ArrayList();
    JPanel ten = this;
    public class KropelkaRunnable implements Runnable{


        KropelkaRunnable(Kropelka kropelka){

        this.kropelka = kropelka;



        }

        public KropelkaRunnable() {

        }


        @Override
        public void run() {
            try{
            while(!Thread.currentThread().isInterrupted()){




                this.kropelka.ruszKropelka(ten);
                repaint();






                    Thread.sleep(1);




            }

            } catch (InterruptedException e) {
                listaKropelek.clear();
                repaint();
            }

        }


        Kropelka kropelka;
    }

}
}
class Kropelka{

    public static Image GetImage(){
        return Kropelka.kropelka;
    }
    public void ruszKropelka(JPanel pojemnik){
        x+= dx;
        y+= dy;
        Rectangle granicePanelu = pojemnik.getBounds();


        if(y+ yKropelki >= granicePanelu.getMaxY()){

            y = ((int)granicePanelu.getMaxY() - yKropelki);
            dy = -dy;

        }

        if(x+ xKropelki >= granicePanelu.getMaxX()){

            x = ((int)granicePanelu.getMaxX() - xKropelki);
            dx = -dx;

        }

        if(y< granicePanelu.getMinY()){
            y = (int)granicePanelu.getMinY();
            dy = -dy;

        }

        if(x< granicePanelu.getMinX()){
           x = (int)granicePanelu.getMinX();
            dx = -dx;

        }


    }
    public static Image kropelka = new ImageIcon("kropelka.gif").getImage();
    int x = 0;
    int y = 0;

    int dx = 1;
    int dy = 1;

    int xKropelki = kropelka.getWidth(null);
    int yKropelki = kropelka.getHeight(null);
}