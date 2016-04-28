/////////////////////////////////
///
///  Resoldre com cullons va el rol i el jugador i la carta
///  ¿ Com fer que per exemple en l'acció de rol del Rei, resti 3 monedes del Banc Nacional i les sumi al Rei ?
///
////////////////////////////////
package projecteprogramaciolmp;

import java.util.ArrayList;

/**
 *
 * @author aerop
 */
import java.util.ArrayList;
public abstract class Jugador {
    // Atributs
    // --------------------
    private Moneda _monedes; // Monedes de les que disposa el jugador
    private int _cartaJugada; // Carta que el Jugador utilitza en el torn
    private ArrayList<Carta> _cartesJugador;
    // --------------------
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Jugador(){
        _monedes= new Moneda();
        _cartaJugada=0;
    }
    
    public Jugador(int monedes){
        
        _monedes= new Moneda(monedes);
        
    }
    
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
       
    
    // ============================================================
    // Mètodes MODIFICADORS
    // ============================================================
       public void pagarMulta(){
       // Pre: --
       // Post: Resta una moneda al jugador per afegir-la al Palau de Justicia
            _monedes.afegirMonedes(-1);
       }
       
       public void afegirMonedes (int mon) {
       // Pre: mon >=0 mon <=0
       // Post: Realitza la operació _monedes + mon
            _monedes.afegirMonedes(mon);
       }
       
       public Moneda retornaMonedes(){
           return _monedes;
       }
       public void esborrarCarta(int nCarta){
           _cartesJugador.remove(nCarta);
       }
       public void afegirCarta(Carta nova){
           _cartesJugador.add(nova);
       }
       public int nCartes(){
           return _cartesJugador.size();
       }
}
