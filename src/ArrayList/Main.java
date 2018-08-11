package ArrayList;

import java.util.LinkedList;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

/* ArrayList
Szybki dostęp do zawartości
wolna przy dodwaniau / odejmowaniu nowych elementow
uzywamy gdy chcemy dużo czytać

*----------------
* |  |  |
* |  |  |
*----------------
*
*/




/* LinkedList
*
* wolne pobieranie wartosci \ wolne przeszukiwanie
* szybka mozliwosc dodawania oraz usuwania elementow
* uzywamy gdy tablica caly czas sie zmienia
*
*
*
 */
        ArrayList listaTablicowa = new ArrayList(6);
        LinkedList listaPolaczona1;
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());
        listaTablicowa.add(new Object());

        ListaPolaczona listaPolaczona = new ListaPolaczona();
        listaPolaczona.wartosc = 10;
        listaPolaczona.nastepna = new ListaPolaczona();
        listaPolaczona.nastepna.wartosc = 20;
        listaPolaczona.nastepna.nastepna = new ListaPolaczona();
        listaPolaczona.nastepna.nastepna.wartosc = 30;

        System.out.println(listaPolaczona.wartosc);
        System.out.println(listaPolaczona.nastepna.wartosc);
        System.out.println(listaPolaczona.nastepna.nastepna.wartosc);
    }
}

class ListaPolaczona{
    int wartosc;
    ListaPolaczona nastepna;
    ListaPolaczona poprzedni;

}