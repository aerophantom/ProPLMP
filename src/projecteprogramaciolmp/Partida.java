
package projecteprogramaciolmp;

import java.util.ArrayList;

public class Partida {
    // Atributs
    // --------------------
    private int _monJusticia; // Monedes del palau de justícia
    private int _monBanc; // Monedes del banc nacional
    private int _jugadorActual; // Index de l'array de jugadors que indica el jugador actual.
    private int _monedesPerGuanyar;
    private ArrayList<Jugador> _JugadorsQueJuguen;
    private ArrayList<Carta>  _mazo;
    
    // --------------------
    // ============================================================
    // CONSTRUCTORS
    // ============================================================
        public Partida(){
            
        }
        /*
        public Partida(int nJugadors, int nMonedes)
        */
    // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
       public Partida() {
      
           _monJusticia=0;
           _monBanc=0;
       }
       
       public Partida(int monJusticia,int monBanc) {
      
           _monJusticia=0;
           _monBanc=monBanc;
       }
    
    
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
        public ArrayList<Jugador> buscarJugadorMesRic () {
        // Pre: --
        // Post: Retorna un vector amb el/s jugador/s més rics
            
        }
        
        public boolean partidaAcabada () {
        // Pre: --
        // Post: Retorna TRUE si la partida s'ha acabat (algun jugador ja arribat al màxim de monedes per guanyar o pel
        // contrari, algun altre se'n ha quedar sense
            
            //int monedesJugadorActual= _JugadorsQueJuguen[_jugadorActual].monedes();
            //boolean acabada = monedesJugadorActual == 0  || monedesJugadorActual >= _monedesPerGuanyar;
            //return acabada;
        }
    
    // ============================================================
    // Mètodes MODIFICADORS
    // ============================================================
        public void repartirCartes () {
        // Pre: --
        // Post: Reparteix les cartes als diferents jugadors de la partida
            
        }

        private void descartarCartes () {
        // Pre: --
        // Post: Descarta cartes de la pila --->>>> (Quantes????)
        
        }

        public void pagarMulta () {
        //Pre: --
        //Post: Afegeix una moneda al palau de justícia i resta'n una al/s jugador/s mentider/s.
        
        }
    
    
}
