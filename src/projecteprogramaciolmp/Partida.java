
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;

public class Partida {
    // Atributs
    // --------------------
    private int _monJusticia; // Monedes del palau de justícia
    private int _monBanc; // Monedes del banc nacional
    private int _jugadorActual; // Index de l'array de jugadors que indica el jugador actual.
    private int _monedesPerGuanyar;
    private int _monedesTotals;
    private ArrayList<Jugador> _JugadorsQueJuguen;
    private ArrayList<Carta>  _mazo;
    
    // --------------------
    // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
       public Partida() {
      
           _monJusticia=0;
           _monBanc=0;
       }
       
       public Partida(int nJugadors, int monJusticia,int monBanc) {
           _JugadorsQueJuguen= new ArrayList<Jugador> (nJugadors); //array de nJugadors
           /* for (i=0; i< nJugadors; i++){
                _JugadorsQueJuguen[i].setJugador(nomJugador,monedes); //com coi implementem aixo?
              }
           */
           _monJusticia=0;
           _monBanc=_monedesTotals - 6*nJugadors; //el 6 son les monedes per jugador
           
           _mazo= new ArrayList<Carta>(Arrays.asList(new Carta("Rei"),new Carta("Reina"),new Carta("Camperol"),new Carta("Bisbe"),new Carta("Espia"),new Carta("Inquisidor"),new Carta("Jutge"),new Carta("Lladre"),new Carta("Trampos"),new Carta("Viuda"),new Carta("Buffo"),new Carta("Bruixa") ));
       }
    
    
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
        public ArrayList<Jugador> buscarJugadorMesRic () {
        // Pre: --
        // Post: Retorna un vector amb el/s jugador/s més rics
            /*
            PER COMPLETAR
            int topMonedas= 0;
            ArrayList<Jugador
            for(int i= 0; i<_jugadorsQueJuguen.size(); i++){
                if(_JugadorsQueJuguen[i].monedes()>= topMonedes){
                    
                }
            }
        */
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
