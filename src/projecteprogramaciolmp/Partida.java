
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Partida {
    // Atributs
    // --------------------
    private Moneda _monedesJusticia; // Monedes del palau de justícia
    private Moneda _monedesBanc; // Monedes del banc nacional
    private int _jugadorActual; // Index de l'array de jugadors que indica el jugador actual.
    private int _monedesPerGuanyar;
    private int _monedesTotals;
    private ArrayList<Jugador> _Jugadors;
    private ArrayList<Carta>  _mazo;
    private ArrayList<Integer> _ordre; // array amb l'ordre de tirades. L'int determina la posició del vector del jugador.
    
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
       public void PartidaSettings(int nJugadors){
           //en el cas que no s'indiquin les monedes per jugador, s'invocara el 
           //seguent metode que te per defecte 6 monedes per jugador.
           PartidaSettings(nJugadors,6);
       }
       public void PartidaSettings(int nJugadors,int monedesPerJugador) {
           _Jugadors= new ArrayList<Jugador> (nJugadors); //array de nJugadors
           /* for (i=0; i< nJugadors; i++){
                _JugadorsQueJuguen[i].setJugador(nomJugador,monedes); //com coi implementem aixo?
              }
           */
           
           
           //inicialització del mazo. potser no va aqui, millor al constructor?
           //EL BISBE NO EL FIQUEM JA AL MAZO JA QUE SEMPRE ANIRA A UN JUGADOR
           //Y ES REPARTIRA AMB TOTAL SEGURETAT AL METODE CORRESPONENT.
           _mazo= new ArrayList<>(Arrays.asList(
                   new Carta(new Reina()),new Carta(new Camperol()),
                   new Carta(new Camperol()),new Carta(new Rei()),
                   new Carta(new Espia()),new Carta(new Inquisidor()),
                   new Carta(new Jutge()),new Carta(new Lladre()),
                   new Carta(new Trampos()),new Carta(new Viuda()),
                   new Carta(new Buffo()),new Carta(new Bruixa()) ));
           
           
           EstablirOrdre();
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
        
        private void EstablirOrdre() {
         
            int aux, nJugadors= _Jugadors.size();
            
            for (int i=0;i<nJugadors;i++){
                aux= ThreadLocalRandom.current().nextInt(0,nJugadors);               //random(0..nJugadors-1); //No es pot repetir el numero d'ordre
                while (_ordre.contains(aux)){
                    aux++;
                    if (aux>=nJugadors) 
                        aux=0;
                }
                _ordre.set(i, aux);
            }
        }
        
        public boolean partidaAcabada () {
        // Pre: --
        // Post: Retorna TRUE si la partida s'ha acabat (algun jugador ja arribat al màxim de monedes per guanyar o pel
        // contrari, algun altre se'n ha quedar sense
            
            //Implementar quan s'acabi el torn d'un jugador.
            
            boolean fiPartida= false;
            int i= 0;
            while(i<_Jugadors.size() && !fiPartida){
                 Moneda monedesJugadorActual= _Jugadors.get(i).retornaMonedes();
                 int quantitatMonedesJugadorActual= monedesJugadorActual.retornaQuantitat();
                 fiPartida= quantitatMonedesJugadorActual == 0  || quantitatMonedesJugadorActual >= _monedesPerGuanyar;
                 i++;
            }
            return fiPartida;
        }
    
    // ============================================================
    // Mètodes MODIFICADORS
    // ============================================================
        public void repartirCartes () {
        // Pre: --
        // Post: Reparteix les cartes als diferents jugadors de la partida
            //ESQUEMA:
                int nCartesPerJugador= 4;
                if(_Jugadors.size()==2)
                    nCartesPerJugador= 3;
                else if(_Jugadors.size()==3)
                    nCartesPerJugador= 2;
                
                //REPARTIR BISBE
                int jugadorRandom= ThreadLocalRandom.current().nextInt(0,_Jugadors.size());
                _Jugadors.get(jugadorRandom).afegirCarta(new Carta(new Bisbe()));
                
                for(int i= 0; i<_Jugadors.size(); i++){
                    int nCartes= _Jugadors.get(i).nCartes();
                    while(nCartes<nCartesPerJugador){
                        int carta= ThreadLocalRandom.current().nextInt(0,_mazo.size());
                        
                        _Jugadors.get(i).afegirCarta(_mazo.get(carta));
                        _mazo.remove(carta);
                        nCartes++;
                    }
               
                }
        /*PROBLEMES: No s'hi fixa en les limitacions de la pag. 7 del PDF, cal pensar-lo.
        edit: al moodle hi ha encara mes restriccions
        ANOTACIO: cal definir el metode per descartar cartes per consens dels
        jugadors (pag. 7 - 3er parragref - PDF)
            */
        
        }

        private void descartarCartes () {
        // Pre: El bisbe no pot ser descartat.
        // Post: Descarta cartes de la pila --->>>> (Quantes????)
        //resposta: es pot descartar quantes volguem sempre que quedi almenys una
        //al mazo.
        
        /* Per descartar cartes recorrem el mazo carta per carta. En cas que els 3 jugadors diguin sí a la carta actual, es descarta;
        en cas que hi hagi un o més "no" ja no es descarta. Restriccions a l'hora de descartar certes cartes, com el bisbe.
        */
        
        /*
        for (i=0;i<_mazo.size()-1;i++){
            mazo[i].mostrarPerPantalla
            int aux=0;
            boolean decisio=juadorsQueJuguen[_ordre[aux]].accio.decidir();
            aux++;
            while (aux<_ordre.size()-1 && decisio) {
                 decisio=juadorsQueJuguen[_ordre[aux]].accio.decidir();
                 aux++;
            }
            if (decisio) {
                _mazo.erase[i];
                i--;
            } // Si els tres hem dit que sí, esborrem la carta i decrementem en 1 l'índex.
            
        */
        }

        public void pagarMulta () {
        //Pre: --
        //Post: Afegeix una moneda al palau de justícia i resta'n una al/s jugador/s mentider/s.
        
        }
        
        public void dinamicaDelJoc(){
            
            /*
            _JugadorActual= 0;
            while(!partidaAcabada){
                //OPCIO 1 - ES PREGUNTA LA ACCIO QUE ES VOL FER DESDE EL PROPI JUGADOR (ACCIO ATRIBUT DE JUGADOR)
                _Jugadors.get(_ordre.get(_JugadorActual)).accio();//el jugador fa la seva accio (veureCarta, accioRol o Intercanvi)
            
                //OPCIO 2 - ES PREGUNTA LA ACCIO QUE ES VOL FER DESDE LA PARTIDA (ACCCIO ATRIBUT DE PARTIDA)
                int opcio;
                if(opcio == 0) {
                    //SELECCIONA CARTA PROPIA DEL JUGADOR ACTUAL
                    mostrarCartesJugadorInterficie(JugadorActual);
                    int intercanvi_u = rebreSignalGUI();
                    
                    //SELECCIONA JUGADOR
                    mostrarJugadorsVectorInterficie();
                    int aux = rebreSignalGUI();
                    
                    //SELECCIONA CARTA DEL JUGADOR  
                    mostrarCartesJugadorInterficie(aux);
                    int aux2 = rebreSignalGUI();
                    
                    
                    
                    atributAccio.ferIntercanvi()
                    
                else if(opcio == 1) ferConsulta
                else ferAccioRol
            
            */
        }
    
}
