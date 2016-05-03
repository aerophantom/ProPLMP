
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Partida {
    // Atributs
    // --------------------
    private Moneda _monedesJusticia; // Monedes del palau de justícia
    private Moneda _monedesBanc; // Monedes del banc nacional
    private int _indexOrdre; // Index de l'array de _ordre que indica el jugador actual. --> numero Torn
    private int _indexExecutador; // Index de l'array _Jugadors que indica el jugador que executarà l'acció de rol.
    private int _monedesPerGuanyar;
    private int _monedesTotals;
    private int _numJugadors;
    private ArrayList<Jugador> _Jugadors;
    private ArrayList<Carta>  _mazo;
    private ArrayList<Integer> _ordre; // array amb l'ordre de tirades. L'int determina la posició del vector del jugador.
    private int _nCartesPerJugador;
    private boolean _fiPartida;
    /*COMENTARI: L'ordre es arbitrari: llavors hem d'implementar un metode que 
    establexi aquest ordre (pag. 9 - 1er parragref - PDF)
    */
    // --------------------
    
    
        
////// ================================================================================================================= //////
//////                                              Mètodes MODIFICADORS                                                 //////
////// ================================================================================================================= //////
       public Partida() {
           _monedesJusticia= new Moneda();
           _monedesBanc= new Moneda(Integer.MAX_VALUE); //al banc mai se li acaben les monedes.
           _indexOrdre = 0;
           _indexExecutador = 0;
       }
       
////// ================================================================================================================= //////
//////                                              Mètodes MODIFICADORS                                                 //////
////// ================================================================================================================= //////
        
       public int getNumJugadors() {
        // Pre: --
        // Post: Retorna el num de jugadors de la partida
            return _numJugadors;
        }
        
        public int getIndexOrdre() {
        // Pre: --
        // Post: Retorna l'index de l'ordre de jugador de la partida
            return _indexOrdre;
        }
        
        
        public ArrayList<Integer> buscarJugadorMesRic () {
        // Pre: --
        // Post: Retorna un vector amb el/s index de la taula _Jugadors amb els jugador/s més rics
            //PER COMPLETAR
            Moneda topMonedas= new Moneda();                                           // El jugador més ric tindrà topMonedes
            ArrayList<Integer> retorn= new ArrayList<>();                              // Array de retorn dels jugadors més rics de la partida
            for(int i= 0; i<_Jugadors.size(); i++){                                   // Per a tots els jugadors
                if(_Jugadors.get(i).retornaMonedes().compareTo(topMonedas) >= 0){      // Si les monedes del jugador són majors que topMonedes
                    topMonedas.actualitzarMonedes(_Jugadors.get(i).retornaMonedes());  // Actualitza topMonedes
              
                }
            }
            for(int j= 0; j<_Jugadors.size();j++){                                  // Per a tots els jugadors
                if(_Jugadors.get(j).retornaMonedes().compareTo(topMonedas) == 0){   // Mira si algun jugador té topMonedes
                    retorn.add(j);                                                  // Afageix al array
                }
            }
            return retorn;
        }
        
        public boolean partidaAcabada () {
        // Pre: --
        // Post: Retorna TRUE si la partida s'ha acabat 
        // Quan s'acaba? Algun jugador ja arribat al màxim de monedes per guanyar o pel
        // contrari, algun altre se'n ha quedar sense.
            
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
               
        public boolean preguntarJugador(int i) {
        // Pre: i>=0 && i<=nJugadors
        // Post: Retorna la decisió del jugador amb index en l'array i
            return _Jugadors.get(i).decidir();     
        }
        
        public boolean comprovarCartaIJugador() {
        // PER FER
            boolean o = false;
            return o;
        }
        
        public int numeroTorn(){
        // Pre: --
        // Post: Retorna l'índex de l'ordre del jugador
            return _indexOrdre;
        }
        
        public int obtIndexJugadorExecutador(){
            return _indexExecutador;
        }
        
        public boolean preguntarJugadorActual(){
            return _Jugadors.get(_ordre.get(_indexOrdre)).decidir();
        }
        
        public ArrayList<Integer> escollirJugadors(int n){
        // Pre: n>0
        // Post: retorna un array que conté els index de n _Jugadors escollits pel jugador amb el torn actual
            int i= 0;
            int nEscollits= 0;
            ArrayList<Integer> retorn= new ArrayList<>();
            System.out.print("Escull un total de "+n+" jugadors:");
            while(i<_Jugadors.size() && nEscollits<n){
                if(i!=_ordre.get(_indexOrdre)){
                    System.out.print("Vols escollir el jugador "+i+" ?");
                    if(_Jugadors.get(_ordre.get(_indexOrdre)).decidir()){
                        retorn.add(i);
                        nEscollits++;
                    }  
                }
                i++;
                if(i==_Jugadors.size() && nEscollits<n)
                        i= 0;
            }
            return retorn;
        }
        
       
////// ================================================================================================================= //////
//////                                              Mètodes MODIFICADORS                                                 //////
////// ================================================================================================================= //////
       
       public void PartidaSettings(int nJugadors){
       // Pre: nJugadors = 2 or 3 or 4
       // Post: Ajusta les opcions de partida invocant un segon metode
       //en el cas que no s'indiquin les monedes per jugador, s'invocara el 
       //seguent metode que te per defecte 6 monedes per jugador.
           PartidaSettings(nJugadors,6);
       }
       
       public void PartidaSettings(int nJugadors,int monedesPerJugador) {
       // Pre: nJugadors = 2 or 3 or 4
       // Post: Ajusta les opcions de la partida. Estableix ordre i guarda les cartes com toca
           _Jugadors= new ArrayList<> (nJugadors);                                      //array de nJugadors
           _numJugadors=nJugadors;
            for (int i=0; i< nJugadors; i++){                                           // Fes fins a nJugadors...
                JugadorPersona p=new JugadorPersona(new Moneda(monedesPerJugador));     // Crea un jugador
                _Jugadors.add(p);                                                       // Afageix-lo al array
              }
           setMazo();                                                                   // Estableix les cartes del mazo
           EstablirOrdre();                                                             // Estableix un ordre aleatori entre els jugadors
       }
       
       private void setMazo(){
       // Pre: --
       // Post: Guarda en el mazo de cartes totes les cartes amb cada un dels rols
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
       

       
        
        private void EstablirOrdre() {
        // Pre: --
        // Post: Estableix un ordre entre els jugadors de la partida
            int aux, nJugadors= _Jugadors.size();                              // AUX es el numero del jugador de la partida
            _indexOrdre=0; 
            _ordre = new ArrayList<> (nJugadors);
            for (int i=0;i<nJugadors;i++){                                    // Per a cada numero de jugadors
                aux= ThreadLocalRandom.current().nextInt(0,nJugadors);         //random(0..nJugadors-1); 
                while (_ordre.contains(aux)){                                 // Mentres aux ja estigui dins el array
                    aux++;                                                     // Incrementa aux pq sigui diferet
                    if (aux>=nJugadors)                                        // Cas aux sigui superior als jugadors que hi juguen
                        aux=0;                                                 // Inicialitza aux
                }
                _ordre.add(i, aux);                                            //Afageix en la posicio i el jugador amb num aux
            }
            /*
           System.out.println("Ordre establert ");
            for(int i=0; i<_Jugadors.size(); i++){
                System.out.print("Posicio "+i+" -> ");
                System.out.println(_ordre.get(i));
            }
          */
        }
        
        public void trobaPosCarta(String nom){
        // Pre: nom és el jugador de algun rol del joc
        // Post: Esborra la carta dins el array de cartes que té el rol amb aquest nom
            int pos=0;
            boolean trobat=false;
            while (pos < _mazo.size() &&  !trobat){                     // Mentres la posició no superi el tamany de l'array i no trobis la carta
                if (_mazo.get(pos).getNom().equals(nom)) trobat=true;   // Si ho trobes
                else pos++;
            }
            _mazo.remove(pos);
        }

        
        public void repartirCartes () {
        // Pre: --
        // Post: Reparteix les cartes als diferents jugadors de la partida
            //ESQUEMA:
            //  System.out.println("");
            // System.out.println("Hora de repartir les cartes");
            
            int nCartesPerJugador= 1;
            if (_Jugadors.size()<3) {
                nCartesPerJugador= 3;
            }
            if (_Jugadors.size()<4) {
                nCartesPerJugador= 2;
            }   
            
            for (int i=0; i<_mazo.size(); i++){
                _mazo.get(i).ensenya();
            }
                   
            for(int i= 0; i<_Jugadors.size(); i++){
                int nCartes= _Jugadors.get(i).nCartes();
                while(nCartes<_nCartesPerJugador){
                    int carta= ThreadLocalRandom.current().nextInt(0,_mazo.size());
                    // _mazo.get(carta).ensenya();
                    // System.out.println("S'afageix al jugador amb ordre "+i);
                    _Jugadors.get(i).afegirCarta(_mazo.get(carta));
                    _mazo.remove(carta);
                    nCartes++;
                }
            }
        /*PROBLEMES: No s'hi fixa en les limitacions de la pag. 7 del PDF, cal pensar-lo.
        edit: al moodle hi ha encara mes restriccions*/
        }

        private void descartarCartes () {
        // Pre: El bisbe no pot ser descartat.
        // Post: Descarta cartes de la pila sempre i quan n'hi quedi una al mazo de cartes 
            if (_Jugadors.size()<3) {
                trobaPosCarta("Lladre");                        //Esborrem el Lladre
            }
            if (_Jugadors.size()<4) {
                trobaPosCarta("Espia");
                trobaPosCarta("Inquisidor");
            }
            if (_Jugadors.size()<6) {
                for (int q=0; q<_mazo.size(); q++){
                     _mazo.get(q).ensenya();
                }
                System.out.println();
                // Busca el primer camperol i borra'l
                trobaPosCarta("Camperol");
                for (int q=0; q<_mazo.size(); q++){
                     _mazo.get(q).ensenya();
                }
                System.out.println();
                // Busca el segon camperol i borra'l
                trobaPosCarta("Camperol");
                for (int q=0; q<_mazo.size(); q++){
                    _mazo.get(q).ensenya();
                }
                System.out.println();
                // Busca el inquisidor i borra'l
                trobaPosCarta("Inquisidor");    
                for (int q=0; q<_mazo.size(); q++){
                     _mazo.get(q).ensenya();
                }
                System.out.println();
            }  
                
            for (int i=1;i<_mazo.size()-1;i++){                 // Comença des de 1 aixi no es descarta el jutge
                int aux=0;
                
                System.out.println("-=================================================================================-");
                System.out.println("Hora de descartar cartes. Decidiu si la carta corresponent al rol per pantalla");
                System.out.println("ha de ser descartada o no. En cas de que algu es negi, la carta no ho serà.");
                System.out.println("");
               
                _mazo.get(i).ensenya();
                System.out.println("Decideix el jugador " + _ordre.get(aux));
                boolean decisio=_Jugadors.get(_ordre.get(aux)).decidir();
               
                aux++;
                while (aux<_ordre.size() && decisio) {
                     System.out.println("Decideix el jugador " + _ordre.get(aux));
                     decisio=_Jugadors.get(_ordre.get(aux)).decidir();
                     aux++;
                }
                if (decisio) // Si tothom ha decidit descartar-la, descartem la carta
                {
                    boolean camperol = _mazo.get(i).getNom().equals("Camperol"); // Si la carta que es vol borrar es Camperol, camperol = true
                    _mazo.remove(i); // Borra la carta
                    if(camperol) // Si s'ha decidit borrar el camperol
                        trobaPosCarta("Camperol"); // Borra l'altre camperol
                    i--;
                } 
                System.out.println("");
                for (int q=0; q<_mazo.size(); q++){
                         _mazo.get(q).ensenya();
                }
                    System.out.println();
            }
            System.out.println("-=================================================================================-");
            
            for (int q=0; q<_mazo.size(); q++){
                _mazo.get(q).ensenya();
            }
            System.out.println();
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
        // Pre: --
        // Post: Mostra totes les cartes de tots els jugadors
            for(int pos=0; pos<_ordre.size(); pos++){
                System.out.println("Jugador "+_ordre.get(pos));
                _Jugadors.get(_ordre.get(pos)).ensenyaCartes();
            }
        }
        
        public int buscaCarta(String nom){
            boolean trobada = false;
            int pos = 0;
            while (!trobada && pos < _mazo.size()){
                if (_mazo.get(pos).getNom().equals(nom)) trobada=true;
                else pos++;
            }
            return pos;
        }
        
        public void interrupcions() {
             // Pre: --
             // Post: els jugadorsque interrompen mentiders paguen la multa, al que diu la veritat se li guarda l'index a _indexExecutador.
            
            Interrupcio intr;
            _indexExecutador=_indexOrdre; // en cas que ningú menteixi, simplement executarà a qui li tocava segons l'indexOrdre.
            intr.preguntarInterrupcio(this); // li passem la partida actual com a parametre
            
            while (intr.hiHaInterrupcions()) {
               int index=intr.getIndex(); // retornem un index i alhora l'esborrem del vector d'interrupcions.
               if (_Jugadors.get(index).getCartaActual().getRolCarta()==_Jugadors.get(_ordre.get(_indexOrdre)./*rol que ha escollit*/) { //cal fer una comparació entre rols. el getRol i getCarta es podrien unificar en un sol get
                   _indexExecutador=index;
                }
                else  _Jugadors.get(index).pagarMulta();
            }

            
        }
                     
        public void dinamicaDelJoc(){
        // Pre: --
        // Post:
            _indexOrdre= 0;
            boolean partidaAcabada= false;
            PartidaSettings(4);
            descartarCartes();
            repartirCartes();
            
            System.out.println("");
            System.out.println("Aquest es el resultat");
            mostrarCartesPerJugadors();
            
            _indexExecutador = _ordre.get(_indexOrdre);
            System.out.println("Escull un rol dels disponibles");
            for (int q=0; q<_mazo.size(); q++){
                 _mazo.get(q).ensenya();
            }
            System.out.println();
            
            Scanner teclat= new Scanner(System.in);
            String rol = teclat.nextLine();

            Rol juga = _mazo.get(buscaCarta(rol)).getRolCarta();
            _Jugadors.get(_indexExecutador).nouRol(juga);
            _Jugadors.get(_indexExecutador).accioDeRol(this);
            
            
            
            
            // Proves de execució de rols
            /*for (int i=0; i<_numJugadors; i++){
                _indexExecutador = _ordre.get(_indexOrdre);
                Rol _ajugar = _Jugadors.get(_indexExecutador)
            }
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
        // Pre: i>=0
        // Post: Mostra per pantalla la informació relacionada amb el jugador que te el i torn
            System.out.print("Jugador " + i);
            System.out.print("Monedes: " + _Jugadors.get(i).retornaMonedes().retornaQuantitat());
        }

        public void afegirMonedesJugador(int nJugador, int nMonedes){
        // Pre: nJugador >= 0 (nJugador representa l'índex de _nJugadors)
        // Post: 
            _Jugadors.get(nJugador).afegirMonedes(nMonedes);
        }
       
        public int escollirCarta(int nJugador){
        // Pre: --
        // Post: Retorna el índex del array de cartes de _Jugadors[nJugador]. EN cas de que no tingui més d'una carta, retorna 0
            int retorn= 0;
            if(_nCartesPerJugador!=0){
                int i=0;
                boolean escollida= false;
                System.out.print("Escull una carta del jugador "+ nJugador +": ");
                while(i<_nCartesPerJugador && !escollida){
                    System.out.print("Escollir carta nº "+ i +"? ");
                    
                    //A LA SEGUENT LINIA TINC DUBTES
                    escollida= _Jugadors.get(_ordre.get(_indexOrdre)).decidir();
                    if(!escollida)
                        i++;
                    if(!escollida && i==_nCartesPerJugador)
                        i= 0;
                }
            }
            return retorn;
        }
        
        public void intercanviarCartes(){
            
        }
        public void fiPartidaTrampos(int nouLimit){
            _fiPartida = nouLimit<=_Jugadors.get(_indexExecutador).retornaMonedes().retornaQuantitat();//es pot fer amb Moneda per polirlo millor
            _fiPartida= nouLimit<=_Jugadors.get(_indexExecutador).retornaMonedes().retornaQuantitat();//es pot fer amb Moneda per polirlo millor
        }
        public int obtMonedesJugador(int index){
            return _Jugadors.get(index).retornaMonedes().retornaQuantitat();
        }
        public Moneda buidaPalauJusticia(){
        /**
         * PRE:--
         * POST: Retorna un contenidor Moneda amb la quantitat de monedes total
         * del palau de justicia. Ara el palau de justicia te 0 monedes.
         */
            Moneda aux= new Moneda(_monedesJusticia.retornaQuantitat());
            _monedesJusticia.actualitzarMonedes(new Moneda());
            return aux;
        }
    /*
        SUGERENCIA: per fer lo de les queixes recomano fer un 'for' per a tots els jugadors
        (menys el que jugador actual obviament) i anar preguntant si es queixen (decisio). Si
        es queixen --> agregar a un vector de interrupcions.
        */
}
