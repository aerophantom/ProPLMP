
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Partida {
    // Atributs
    // --------------------
    private Moneda _monedesJusticia; // Monedes del palau de justícia
    private Moneda _monedesBanc; // Monedes del banc nacional
    private int _jugadorActual; // Index de l'array de _ordre que indica el jugador actual. --> numero Torn
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
           _Jugadors= new ArrayList<> (nJugadors); //array de nJugadors
            for (int i=0; i< nJugadors; i++){
                JugadorPersona p=new JugadorPersona(new Moneda(monedesPerJugador));
                _Jugadors.add(p); //com coi implementem aixo?
              }
       
           setMazo();
           EstablirOrdre();
       }
       private void setMazo(){
           _mazo= new ArrayList<>(Arrays.asList(
                   new Carta(new Jutge()),
                   new Carta(new Reina()),
                   new Carta(new Rei()),
                   new Carta(new Bisbe()),
                   new Carta(new Viuda()),
                   new Carta(new Buffo()),
                   new Carta(new Bruixa()),
                   new Carta(new Inquisidor()),
                   new Carta(new Camperol()),
                   new Carta(new Camperol()),
                   new Carta(new Trampos()),
                   new Carta(new Espia()),
                   new Carta(new Lladre()) ));
       }
    
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
        public ArrayList<Integer> buscarJugadorMesRic () {
        // Pre: --
        // Post: Retorna un vector amb el/s index de la taula _Jugadors amb els jugador/s més rics
            
            //PER COMPLETAR
            Moneda topMonedas= new Moneda();
            ArrayList<Integer> retorn= new ArrayList<>();
            for(int i= 0; i<_Jugadors.size(); i++){
                if(_Jugadors.get(i).retornaMonedes().compareTo(topMonedas) >= 0){
                    topMonedas.actualitzarMonedes(_Jugadors.get(i).retornaMonedes());
              
                }
            }
            
            for(int j= 0; j<_Jugadors.size();j++){
                if(_Jugadors.get(j).retornaMonedes().compareTo(topMonedas) == 0){
                    retorn.add(j); 
                }
            }
            return retorn;
        }
        
        private void EstablirOrdre() {
         
            int aux, nJugadors= _Jugadors.size();
            _ordre = new ArrayList<> (nJugadors);
            for (int i=0;i<nJugadors;i++){
                aux= ThreadLocalRandom.current().nextInt(0,nJugadors);               //random(0..nJugadors-1); //No es pot repetir el numero d'ordre
                while (_ordre.contains(aux)){
                    aux++;
                    if (aux>=nJugadors) 
                        aux=0;
                }
                _ordre.add(i, aux);
            }
            
            System.out.println("Ordre establert ");
            for(int i=0; i<_Jugadors.size(); i++){
                System.out.print("Posicio "+i+" -> ");
                System.out.println(_ordre.get(i));
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
                int nCartesPerJugador= 1;
                if (_Jugadors.size()<3) {
                    nCartesPerJugador= 3;
                    _mazo.remove(_mazo.size()-1); //Esborrem el Lladre
                }
                if (_Jugadors.size()<4) {
                    nCartesPerJugador= 2;
                    _mazo.remove(_mazo.size()-2); //Esborrem el Espia
                    _mazo.remove(_mazo.size()-3); //Esborrem el Trampos
                }
                 if (_Jugadors.size()<6) {
                    _mazo.remove(_mazo.size()-4); 
                    _mazo.remove(_mazo.size()-5); //Esborrem els dos camperols.
                    _mazo.remove(_mazo.size()-6); //Esborrem l'Inquisidor
                }
                
                
                //CAL fer que el jutge no sigui mai descartat. Responsabilitat del metode descartar
                
                for(int i= 0; i<_Jugadors.size(); i++){
                    int nCartes= _Jugadors.get(i).nCartes();
                    while(nCartes<nCartesPerJugador){
                        int carta= ThreadLocalRandom.current().nextInt(0,_mazo.size());
                        System.out.println("El rol de la carta és ");
                        _mazo.get(carta).ensenya();
                        System.out.println("S'afageix al jugador amb ordre "+i);
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
        // Post: Descarta cartes de la pila sempre i quan n'hi quedi una al mazo de cartes 
  
        /* Per descartar cartes recorrem el mazo carta per carta. En cas que els 3 jugadors diguin sí a la carta actual, es descarta;
        en cas que hi hagi un o més "no" ja no es descarta. Restriccions a l'hora de descartar certes cartes, com el bisbe.
        */
        
            for (int i=1;i<_mazo.size()-1;i++){ //comença desde 1 aixi no es descarta el jutge
                _mazo.get(i).ensenya();
                //mazo[i].mostrarPerPantalla
                int aux=0;
                boolean decisio=_Jugadors.get(_ordre.get(aux)).decidir();

                aux++;
                while (aux<_ordre.size()-1 && decisio) {
                     decisio=_Jugadors.get(_ordre.get(aux)).decidir();
                     aux++;
                }
                if (decisio) {
                    _mazo.remove(i);
                    if(i==_mazo.size()-5)//COMPTE QUE NO SE SI ESTA BE
                        _mazo.remove(i);//cas que s'esborri un camperol, l'altre tambe ho fara
                    i--;
                } // Si els tres hem dit que sí, esborrem la carta i decrementem en 1 l'índex.


            }
        }
        
        
        public void pagarMulta() {
        //Pre: --
        //Post: Afegeix una moneda al palau de justícia i resta'n una al/s jugador/s mentider/s.
        /*
        cal aconseguir d'alguna manera els jugadors que han mentit.
        possible solucio: array (com a atribut potser) de _Jugadors.size() menys 1 (tots poden protestar menys 1)
        
        */
            _monedesJusticia.afegirMonedes(1);
            //_Jugadors.get(_ordre.get(_jugadorActual)).pagarMulta();
        }
        
        
        public void mostrarCartesPerJugadors(){
            for(int pos=0; pos<_Jugadors.size(); pos++){
                _Jugadors.get(pos).ensenyaCartes();
            }
        }
        
        public void dinamicaDelJoc(){
            _jugadorActual= 0;
            boolean partidaAcabada= false;
            PartidaSettings(4);
            descartarCartes();
            repartirCartes();
            mostrarCartesPerJugadors();
            /*
            while(!partidaAcabada){
            }          
            /*
            _JugadorActual= 0;
            while(!partidaAcabada){
                //OPCIO 1 - ES PREGUNTA LA ACCIO QUE ES VOL FER DESDE EL PROPI JUGADOR (ACCIO ATRIBUT DE JUGADOR)
                _Jugadors.get(_ordre.get(_JugadorActual)).accio();//el jugador fa la seva accio (veureCarta, accioRol o Intercanvi)
            
                //OPCIO 2 - ES PREGUNTA LA ACCIO QUE ES VOL FER DESDE LA PARTIDA (ACCIO ATRIBUT DE PARTIDA)
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
                    
              
                    atributAccio.ferIntercanvi();
                    
                else if(opcio == 1) ferConsulta
                else ferAccioRol
            
            */
        }
        
        //metode del gilipolles ja que mai se li acaben les monedes, pero per si de cas el deixo
        public void treureMonedesBanc(int n){
            _monedesBanc.afegirMonedes(-n);
        }
        public void mostrarInfoJugador(int i){
        /**
         * PRE: i >= 0
         * POST: Mostra per pantalla la informacio relacionada amb el jugador que te
         * el <i> torn
         */
            System.out.print("Jugador " + i);
            System.out.print("Monedes: " + _Jugadors.get(i).retornaMonedes().retornaQuantitat());
        }
        public int retornaQuantitatJugadors(){
            return _Jugadors.size();
        }
        public boolean preguntarJugadorActual(){
            return _Jugadors.get(_ordre.get(_jugadorActual)).decidir();
        }
        public void afegirMonedesJugador(int nJugador, int nMonedes){
        /**
         * PRE: nJugador >= 0 (nJugador representa l'index de _Jugadors)
         * POST:
         */
            _Jugadors.get(nJugador).afegirMonedes(nMonedes);
        }
        public int numeroTorn(){
            return _jugadorActual;
        }
    /*
        SUGERENCIA: per fer lo de les queixes recomano fer un 'for' per a tots els jugadors
        (menys el que jugador actual obviament) i anar preguntant si es queixen (decisio). Si
        es queixen --> agregar a un vector de interrupcions.
        */
}
