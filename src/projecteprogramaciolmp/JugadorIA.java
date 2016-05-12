/*
 * ATRIBUTS
queue<cartes> (memoria FIFO - linkedlist
 */
package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class JugadorIA extends Jugador {
    //Atributs
    private LinkedList<Jugador> _memoriaJugadors;//cua de memoria de Jugador.
    private LinkedList<Carta> _cartesEnJoc;//cua de memoria per les cartes que hi ha en joc.
    private ArrayList<Rol> _pesos;
    private double _probEncert;
    
   public JugadorIA(Moneda m, int dif){
       _monedes = m;   
       
       if (dif == 0) _probEncert = 0.3;
       else if (dif == 1) _probEncert = 0.4;
       else if (dif == 2) _probEncert = 0.6;
       else _probEncert = 0.8;

   }
   
   @Override
   public void memoriaJugadors(LinkedList<Jugador> j, LinkedList<Carta> c){
       _memoriaJugadors = j;
       _cartesEnJoc = c;
   }
    
}
