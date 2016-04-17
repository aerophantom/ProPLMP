
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Partida {
    // Atributs
    // --------------------
    private Moneda _monedesJusticia; // Monedes del palau de justícia
    private Moneda _monedesBanc; // Monedes del banc nacional
    private int _jugadorActual; // Index de l'array de jugadors que indica el jugador actual.
    private int _monedesPerGuanyar;
    private int _monedesTotals;
    private ArrayList<Jugador> _JugadorsQueJuguen;
    private ArrayList<Carta>  _mazo;
    /
    /*COMENTARI: L'ordre es arbitrari: llavors hem d'implementar un metode que 
    establexi aquest ordre (pag. 9 - 1er parragref - PDF)
    */
    // --------------------
    // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
       public Partida() {
      
           _monedesJusticia= new Moneda();
           _monedesBanc= new Moneda(Integer.MAX_VALUE); //al banc mai se li acaben les monedes.
       }
       public void PartidaSettings(int nJugadors, int monedesJusticia){
           //en el cas que no s'indiquin les monedes per jugador, s'invocara el 
           //seguent metode que te per defecte 6 monedes per jugador.
           PartidaSettings(nJugadors,monedesJusticia,6);
       }
       public void PartidaSettings(int nJugadors, int monedesJusticia,int monedesPerJugador) {
           _JugadorsQueJuguen= new ArrayList<Jugador> (nJugadors); //array de nJugadors
           /* for (i=0; i< nJugadors; i++){
                _JugadorsQueJuguen[i].setJugador(nomJugador,monedes); //com coi implementem aixo?
              }
           */
           _monedesJusticia=0;
           
           //inicialització del mazo.
           _mazo= new ArrayList<>(Arrays.asList(new Carta(new Rei()),new Carta(new Reina()),new Carta(new Camperol()),new Carta(new Camperol()),new Carta(new Bisbe()),new Carta(new Espia()),new Carta(new Inquisidor()),new Carta(new Jutge()),new Carta(new Lladre()),new Carta(new Trampos()),new Carta(new Viuda()),new Carta(new Buffo()),new Carta(new Bruixa()) ));
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
            /*ESQUEMA:
                int nCartesPerJugador= 4;
                if(vectorJugadors.size()==2)
                    nCartesPerJugador= 3;
                else if(vectorJugadors.size()==3)
                    nCartesPerJugador= 2;
        
                for(int i= 0; i<nJugadors; i++){
                    for(int j= 0; j<nCartesPerJugador; j++){
                        int carta= RANDOM(entre 0 i vectorCartes.size()-1);
                        
                        vectorJugador[i].afegirCarta(vectorCartes[carta]);
                        vectorCartes[carta].erase();
                        
        PROBLEMES: No s'hi fixa en les limitacions de la pag. 7 del PDF, cal pensar-lo
        ANOTACIO: cal definir el metode per descartar cartes per consens dels
        jugadors (pag. 7 - 3er parragref - PDF)
            */
        
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
