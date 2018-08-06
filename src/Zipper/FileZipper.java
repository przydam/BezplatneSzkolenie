package Zipper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class FileZipper extends JFrame
{
    public FileZipper()
    {
        this.setTitle("Zipper");
        this.setBounds(275, 300, 250, 250);
        this.setJMenuBar(pasekMenu);

        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));

        Action akcjaDodawania = new Akcja("Dodaj", "Dodaj nowy wpis do archiwum", "ctrl D", new ImageIcon("dodaj.png"));
        Action akcjaUsuwania = new Akcja("UsuĹ„", "UsuĹ„ zaznaczony/zaznaczone wpisy z archiwum", "ctrl U", new ImageIcon("usun.png"));
        Action akcjaZipowania = new Akcja("Zip", "Zipuj", "ctrl Z");

        JMenuItem menuOtworz = menuPlik.add(akcjaDodawania);
        JMenuItem menuUsun = menuPlik.add(akcjaUsuwania);
        JMenuItem menuZip = menuPlik.add(akcjaZipowania);

        bDodaj = new JButton(akcjaDodawania);
        bUsun = new JButton(akcjaUsuwania);
        bZip = new JButton(akcjaZipowania);
        JScrollPane scrollek = new JScrollPane(lista);

        lista.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout layout = new GroupLayout(this.getContentPane());

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(scrollek, 100, 150, Short.MAX_VALUE)
                        .addContainerGap(0, Short.MAX_VALUE)
                        .addGroup(
                                layout.createParallelGroup().addComponent(bDodaj).addComponent(bUsun).addComponent(bZip)

                        )
        );

        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(scrollek, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup().addComponent(bDodaj).addComponent(bUsun).addGap(5, 40, Short.MAX_VALUE).addComponent(bZip))
        );

        this.getContentPane().setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
    }
    private DefaultListModel modelListy = new DefaultListModel()
    {
        @Override
        public void addElement(Object obj)
        {
            lista.add(obj);
            super.addElement(((File)obj).getName());
        }
        @Override
        public Object get(int index)
        {
            return lista.get(index);
        }

        ArrayList lista = new ArrayList();
    };
    private JList lista = new JList(modelListy);
    private JButton bDodaj;
    private JButton bUsun;
    private JButton bZip;
    private JMenuBar pasekMenu = new JMenuBar();
    private JFileChooser wybieracz = new JFileChooser();
    public static void main(String[] args)
    {
        new FileZipper().setVisible(true);
    }

    private class Akcja extends AbstractAction
    {
        public Akcja(String nazwa, String opis, String klawiaturowySkrot)
        {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot));
        }
        public Akcja(String nazwa, String opis, String klawiaturowySkrot, Icon ikona)
        {
            this(nazwa, opis ,klawiaturowySkrot);
            this.putValue(Action.SMALL_ICON, ikona);
        }

        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Dodaj"))
                dodajWpisyDoArchiwum();
            else if (e.getActionCommand().equals("UsuĹ„"))
                System.out.println("Usuwanie");
            else if (e.getActionCommand().equals("Zip"))
                System.out.println("Zipowanie");
        }

        private void dodajWpisyDoArchiwum()
        {
            wybieracz.setCurrentDirectory(new File(System.getProperty("user.dir")));
            wybieracz.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            wybieracz.setMultiSelectionEnabled(true);

            int tmp = wybieracz.showDialog(rootPane, "Dodaj do archiwum");

            if (tmp == JFileChooser.APPROVE_OPTION)
            {
                File[] sciezki = wybieracz.getSelectedFiles();

                for (int i = 0; i < sciezki.length; i++)
                    if(!czyWpisSiePowtarza(sciezki[i].getPath()))
                        modelListy.addElement(sciezki[i]);

            }
        }
        private boolean czyWpisSiePowtarza(String testowanyWpis)
        {
            for (int i = 0; i < modelListy.getSize(); i++)
                if (((File)modelListy.get(i)).getPath().equals(testowanyWpis))
                    return true;

            return false;
        }
    }

}

