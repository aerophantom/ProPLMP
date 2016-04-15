
package projecteprogramaciolmp;



public class Partida {
    // Atributs
    // --------------------
    private int _monJusticia; // Monedes del palau de justícia
    private int _monBanc; // Monedes del banc nacional
    // private vector<Jugadors> _JugadorsQueJuguen
    // private vector<Cartes>  _CartesQueDisposaElJoc
    
    // --------------------
    
    // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
       public Partida() {
      
           _monJusticia=0;
           _monBanc=0;
       }
       
       public Partida(int monJusticia,int monBanc) {
      
           _monJusticia=monJusticia;
           _monBanc=monBanc;
       }
    
    
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
        public void vector<Jugador> buscarJugadorMesRic () {
        // Pre: --
        // Post: Retorna un vector amb el/s jugador/s més rics
            
        }
        
        public boolean partidaAcabada () {
        // Pre: --
        // Post: Retorna TRUE si la partida s'ha acabat (algun jugador ja arribat al màxim de monedes per guanyar o pel
        // contrari, algun altre se'n ha quedar sense
            boolean acabada = false;
            
            return acabada;
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
