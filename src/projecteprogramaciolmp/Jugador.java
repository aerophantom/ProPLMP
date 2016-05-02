/////////////////////////////////
///
///  Resoldre com cullons va el rol i el jugador i la carta
///  ¿ Com fer que per exemple en l'acció de rol del Rei, resti 3 monedes del Banc Nacional i les sumi al Rei ?
///
////////////////////////////////
package projecteprogramaciolmp;
import java.util.ArrayList;
public abstract class Jugador {
    // Atributs
    // --------------------
    Moneda _monedes; // Monedes de les que disposa el jugador
    private int _cartaJugada; // Carta que el Jugador utilitza en el torn
    private ArrayList<Carta> _cartesJugador;
    Accio _accion;
    // --------------------
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Jugador(){
        _monedes= new Moneda();
        _cartaJugada=0;
        _accion = new Accio();
        _cartesJugador = new ArrayList<> (3);
    }
    
    public Jugador(int monedes){
        _accion= new Accio();
        _monedes= new Moneda(monedes);
        _cartesJugador = new ArrayList<> (3);
        
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
            //_monedes.afegirMonedes(mon);
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
           int nC = _cartesJugador.size();
           System.out.println(nC);
           return _cartesJugador.size();
       }
       public boolean decidir(){
          return _accion.decidir();
       }
       
       public void ensenyaCartes(){
           for(int i=0; i<_cartesJugador.size(); i++){
               _cartesJugador.get(i).ensenya();
           }
       }
}
