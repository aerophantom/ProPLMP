/////////////////////////////////
///
///  Resoldre com cullons va el rol i el jugador i la carta
///  ¿ Com fer que per exemple en l'acció de rol del Rei, resti 3 monedes del Banc Nacional i les sumi al Rei ?
///
////////////////////////////////
package projecteprogramaciolmp;

/**
 *
 * @author aerop
 */
public abstract class Jugador {
    // Atributs
    // --------------------
    private int _monedes; // Monedes de les que disposa el jugador
    private int _cartaJugada; // Carta que el Jugador utilitza en el torn
    // private vector<Cartes> _cartesJugador 
    // --------------------
    
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
       
    
    // ============================================================
    // Mètodes MODIFICADORS
    // ============================================================
       public void pagarMulta(){
       // Pre: --
       // Post: Resta una moneda al jugador per afegir-la al Palau de Justicia
       
       }
       
       public void afegirMonedes (int mon) {
       // Pre: mon >=0 mon <=0
       // Post: Realitza la operació _monedes + mon
       
       }
}
