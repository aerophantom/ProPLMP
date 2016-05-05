
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Partida {
    // Atributs
    // --------------------
    private Moneda _monedesJusticia;          // Monedes del palau de justícia
    private Moneda _monedesBanc;              // Monedes del banc nacional
    private int _indexOrdre;                 // Index de l'array de _ordre que indica el jugador actual. --> numero Torn
    private int _indexExecutador;            // Index de l'array _Jugadors que indica el jugador que executarà l'acció de rol.
    private int _monedesPerGuanyar;          // Monedes necessàries per a que un jugador guanyi la partida
    private int _monedesTotals;              // Monedes totals en la partida
    private int _numJugadors;                // Num de jugadors que juguen en la partida
    private ArrayList<Jugador> _Jugadors;    // Array dels jugadors que estan en la partida
    private ArrayList<Carta>  _mazo;         // Cartes disponibles en la partida (NO ESTÀN DESCARTADES I TAMPOC LES TENEN ELS JUGADORS)
    private ArrayList<Carta> _rolsDisp;      // Rols disponibles per jugadr (NO ESTÀN DESCARTADES I PODEN TENIR-HO ELS JUGADORS)
    private ArrayList<Integer> _ordre;       // Array amb l'ordre de tirades. L'indexOrdre determina la posició en el vector del jugador.
    private int _nCartesPerJugador;         // Num de cartes que toca repartir a cada jugador
    private boolean _fiPartida;            // Si _fiPartida = TRUE la partida ha complert les condicions per acabar, altrament FALSE
    // --------------------
    
    
        
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              CONSTRUCTORS                                                         //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
       public Partida() {
           _monedesJusticia= new Moneda();              // Monedes del Palau de Justicia
           _monedesBanc= new Moneda(Integer.MAX_VALUE); // Al banc mai se li acaben les monedes.
           _indexOrdre = 0;                             // Index per moure's pel vector que determina l'ordre dels jugadors
           _indexExecutador = 0;                        // Index per saber dins el vector de jugadors quins jugador està jugant
       }
       
     
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES CONSULTORS                                                   //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
        
       public int eleccioMenu(){
       // Pre:    
       // Post:
            int opcio = -1;
            System.out.println("=================================================================================================================");
            System.out.println("Escull un número dels següents per triar que fer en el joc:");
            System.out.println("1 .- Segueix amb el joc");
            System.out.println("2 .- Mostra l'estat de la partida");
            System.out.println("3 .- Mostra les cartes dels jugadors");
            System.out.println("=================================================================================================================");
            System.out.println("");
            
            Scanner teclat = new Scanner(System.in);
            opcio = teclat.nextInt();
            
            return opcio;
       }
       
       
       public int triarAccio() {
       // Pre:   
       // Post:
            System.out.println("===================================================================================");
            System.out.println("1 .- Fer accio de rol");
            System.out.println("2 .- Intercanviar cartes amb el mazo disponible");
            System.out.println("3 .- Consultar una carta de les que tens");
            System.out.println("===================================================================================");           
            System.out.println("");
            Scanner teclat= new Scanner(System.in);
            int opcio = teclat.nextInt();
            return opcio;
       }
       
       public Rol escollirRol(){
       // Pre: --
       // Post: Retorna el rol determinat per un string entrat. El string ha de fer referència a un rol existent
            System.out.print("Elecció: ");
            Scanner teclat= new Scanner(System.in);
            String rol = teclat.nextLine();
            int posC = buscaCarta(rol);
            while (posC == -1){
                System.out.println("El rol entrat no existeix. Elecció: ");
                rol = teclat.nextLine();
                posC = buscaCarta(rol);
            }
            Rol juga = _rolsDisp.get(buscaCarta(rol)).getRolCarta();
            return juga;
        }
               
       public int getNumJugadors() {
        // Pre: --
        // Post: Retorna el num de jugadors de la partida
        
            return _numJugadors;        // Retorna el número de jugadors de la partida
        }
      
        public int getIndexExecutadorOrdre(){
        // Pre: --
        // Post: Retorna el num de la posició del _jugador determinat per l'index executador
        
            return _Jugadors.indexOf(_indexExecutador);
        }
        
        public int obtIndexCorregit(int indexOrdre){
        // Pre: indexOrdre >=0 i indexOrdre < numJugadors
        // Post: Retorna el num del jugador que li toca el torn
        
            return _ordre.get(indexOrdre);
        }
        public int getIndexOrdre() {
        // Pre: --
        // Post: Retorna l'index de l'ordre de jugador de la partida
        
            return _indexOrdre;         // Retorna el índex per moure's pel vector d'ordre de jugadors
        }
        
        
        public ArrayList<Integer> buscarJugadorMesRic () {
        // Pre: --
        // Post: Retorna un vector amb el/s index de la taula _Jugadors amb els jugador/s més rics
        
            //PER COMPLETAR
            Moneda topMonedes= new Moneda();                                           // El jugador més ric tindrà topMonedes
            ArrayList<Integer> retorn= new ArrayList<>();                              // Array de retorn dels jugadors més rics de la partida
            for(int i= 0; i<_Jugadors.size(); i++){                                   // Per a tots els jugadors
                if(_Jugadors.get(i).retornaMonedes().compareTo(topMonedes) >= 0){      // Si les monedes del jugador són majors que topMonedes
                    topMonedes.actualitzarMonedes(_Jugadors.get(i).retornaMonedes());  // Actualitza topMonedes
              
                }
            }
            for(int j= 0; j<_Jugadors.size();j++){                                  // Per a tots els jugadors
                if(_Jugadors.get(j).retornaMonedes().compareTo(topMonedes) == 0){   // Mira si algun jugador té topMonedes
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
        
            boolean fiPartida= false;                                                       // Boolea que determina si s'ha acabat
            int i= 0;
            while(i<_Jugadors.size() && !fiPartida){                                         // Recorre tots els jugadors per comprovar si algun ha arribat al topMonedes guanyar
                 Moneda monedesJugadorActual= _Jugadors.get(i).retornaMonedes();              // Monedes del jugador que estem inspeccionant en el while
                 int quantitatMonedesJugadorActual= monedesJugadorActual.retornaQuantitat();  // Recull en enter el num de monedes 
                 fiPartida= quantitatMonedesJugadorActual == 0  || quantitatMonedesJugadorActual >= _monedesPerGuanyar; // Comprova si arriben al top de monedes
                 i++;                                                                           // Mou al seguent jugador
            }
            return fiPartida;                                                               // Retorna
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
        // Pre: --
        // Post:  Retorna el index del jugador que li toca el seu torn dins el vector de jugadors
        
            return _indexExecutador;
        }
        
        public boolean preguntarJugadorActual(){
        // Pre: --
        // Post: Formula una pregunta de Si o No al jugador que li toca el torn i retorna TRUE si s'ha escollit SI altrament FALSE
        
            return _Jugadors.get(_ordre.get(_indexOrdre)).decidir();        // Formula pregunta
        }
        public boolean preguntarJugador(int i) {
        // Pre: i>=0 && i<=nJugadors
        // Post: Retorna la decisió del jugador amb index en l'array i
        
            return _Jugadors.get(i).decidir();     
        }
        
        public ArrayList<Integer> escollirJugadors(int n){
        // Pre: n>0
        // Post: retorna un array que conté els index de n _Jugadors escollits pel jugador amb el torn actual
        
            int i= 0;                                                           
            int nEscollits= 0;
            ArrayList<Integer> retorn= new ArrayList<>();
            System.out.println("Escull un total de "+n+" jugadors:");
            while(i<_Jugadors.size() && nEscollits<n){                          // Mentres no acabis de recorrer tots els jugador i el numerò d'escollits no superi els permesos
                if(i!=_ordre.get(_indexOrdre)){                                 // Si el jugador on ens trobem actualment és l'executador de l'ordre
                    System.out.println("Vols escollir el jugador "+i+" ?");     // Pregunta
                    if(_Jugadors.get(_ordre.get(_indexOrdre)).decidir()){      // Recull si es que SI o NO
                        retorn.add(i);                                          // Si es que si, afageix el index del jugador al vector
                        nEscollits++;
                    }  
                }
                i++;
                if(i==_Jugadors.size() && nEscollits<n)                         // Si i arriba al maxim del vector i encara no s'han escollit els necessàris
                        i= 0;                                                   // Torna a començar
            }
            return retorn;                                                     // Retorna el vector de jugadors escollits
        }
        
        public void mostrarCartesPerJugadors(){
        // Pre: --
        // Post: Mostra totes les cartes de tots els jugadors
        
            for(int pos=0; pos<_ordre.size(); pos++){                          // Recorrer totes les posicions del vector d'ordre per mostrar les cartes per ordre de jugador
                System.out.println("Jugador "+_ordre.get(pos));                 // Mostra nom del jugador i el seu numero
                _Jugadors.get(_ordre.get(pos)).ensenyaCartes();                 // Ensenya les cartes del jugador seleccionat
            }
        }
        
        public int buscaCarta(String nom){
        // Pre: nom correspon a un nom de algun rol de cartes dels rols que no s'han descartat
        // Post: Retorna la pos on es troba la carta en l'array dels rols disponibles no descartats
        
            boolean trobada = false;                                            // Boolean per retornar 
            int pos = 0;
            while (!trobada && pos < _rolsDisp.size()){                          // Mentres no s'hagi trobat la carta i no s'hagi recorregut tot l'array de cartes disponibles
                if (_rolsDisp.get(pos).getNom().equals(nom)) trobada=true;       // Si l'has trobada, retornaràs TRUE
                else pos++;                                                      // Altrament incrementa l'índex de posicio
            }
            if (!trobada) pos = -1;
            return pos;                                                          // Retorna la posicio de la carta trobada
        }
        
        public void mostrarInfoJugador(int i){
        // Pre: i>=0
        // Post: Mostra per pantalla la informació relacionada amb el jugador que te el i torn
        
            System.out.println("Jugador " + i);
            System.out.println("Monedes: " + _Jugadors.get(i).retornaMonedes().retornaQuantitat());
        }
        
        public int escollirCarta(int nJugador){
        // Pre: --
        // Post: Retorna el índex del array de cartes de _Jugadors[nJugador]. En cas de que no tingui més d'una carta, retorna 0
        
            int retorn= 0;
            if(_nCartesPerJugador>1){                                                       // Cas que el numero de cartes que tenen els jugadors sigui superior a 1
                int i=0;
                boolean escollida= false;
                System.out.print("Escull una carta del jugador "+ nJugador +": ");          // Demana que escullin carta
                while(i<_nCartesPerJugador && !escollida){                                 // Mentres no hagis recorregut les cartes i no s'hagi escollit cap
                    System.out.print("Escollir carta nº "+ i +"? ");
                    
                    //A LA SEGUENT LINIA TINC DUBTES
                    escollida= _Jugadors.get(_ordre.get(_indexOrdre)).decidir();            // Formula pregunta de SI(TRUE) o NO(FALSE)
                    if(!escollida)                                                          // Si no s'ha escollit 
                        i++;                                                                // Incrementa l'index que recorre les cartes
                    if(!escollida && i==_nCartesPerJugador)                                 // Si ja les has recorregut totes però no s'ha escollit res
                        i= 0;                                                               // Torna a recorrer
                }
                retorn=i;
            }
            return retorn;                                                                 // Retorna l'índex de la carta del vector de cartes disponibles del jugador en qüestió
        }
        
        public int obtMonedesJugador(int index){
        // Pre: index >= 0 index < numJugadors
        // Post: Retorna les monedes del jugador dins de _Jugadors[index]
        
            return _Jugadors.get(index).retornaMonedes().retornaQuantitat();               // Retorna la quantitat de monedes del Jugador indicat per index dins el vector de jugadors
        }
        
        public Moneda buidaPalauJusticia(){
        // Pre: --
        // Post: Retorna un contenidor Moneda amb la quantitat de monedes total del palau
        // de justicia. Ara el palau de justicia té 0 monedes.
        
            Moneda aux= new Moneda(_monedesJusticia.retornaQuantitat());                    // Retorna la quantitat de monedes del palau de justicia
            _monedesJusticia.actualitzarMonedes(new Moneda());                              // Renova la quantitat de monedes del palau de justicia per 0 (el constructor ho inicialitza a 0)
            return aux;                                                                     // Retorna la quantitat de monedes
        }
       
        
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES MODIFICADORS                                                 //////
//////                                                                                                                   //////
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
       
           _Jugadors= new ArrayList<> (nJugadors);                                      // Array de nJugadors
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
       
           _mazo = new ArrayList<>(Arrays.asList(
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
           
           _rolsDisp = new ArrayList<>(Arrays.asList(
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
            System.out.println("");
            System.out.println("Ordre establert ");
             for(int i=0; i<_Jugadors.size(); i++){
                 System.out.print("Posicio "+i+" , Jugador ");
                 System.out.println(_ordre.get(i));
             }
             System.out.println("");
        }
        
        public void eliminaCartaNom(String nom){
        // Pre: nom és el jugador de algun rol del joc
        // Post: Esborra la carta dins el array de cartes que té el rol amb aquest nom
        
            int pos=0;
            boolean trobat=false;
            while (pos < _mazo.size() &&  !trobat){                     // Mentres la posició no superi el tamany de l'array i no trobis la carta
                if (_mazo.get(pos).getNom().equals(nom)) trobat=true;   // Si ho trobes
                else pos++;                                             // Altrament incrementa pos
            }
            _mazo.remove(pos);
            _rolsDisp.remove(pos);
        }

        
        public void repartirCartes () {
        // Pre: --
        // Post: Reparteix les cartes als diferents jugadors de la partida
        
            //ESQUEMA:
            //  System.out.println("");
            // System.out.println("Hora de repartir les cartes");
            
            int nCartesPerJugador= 1;                                           // Numero de cartes per jugador a repartir
            if (_Jugadors.size()<3) {                                           // Si el numero de jugadors és menor a 3
                nCartesPerJugador= 3;                                           // Les cartes que toquen a cada jugador és 3
            }
            if (_Jugadors.size()<4) {                                           // Si el numero de jugador és menor a 4
                nCartesPerJugador= 2;                                           // Les cartes que toquena a cada jugador és 2
            }   
            
            for (int i=0; i<_mazo.size(); i++){                                // Ensenya les cartes disponibles des de un principi
                _mazo.get(i).ensenya();
            }
                   
           // System.out.println("Ara toca repartir cartes");
            for(int i= 0; i<_Jugadors.size(); i++){                                         // Per a cada jugador
                int nCartes= _Jugadors.get(i).nCartes();                                    // Agafa el número de cartes del jugador i
                //System.out.println("Num de cartes del jugador "+i+": "+nCartes);
                while(nCartes<=_nCartesPerJugador){                                         // Mentres no s'hagin repartit totes les cartes al jugador corresponent i
                    int carta= ThreadLocalRandom.current().nextInt(0,_mazo.size());         // Agafa un valor random (0 - Tamany del MAZO)
                   // System.out.println(carta);
                   //  _mazo.get(carta).ensenya();                                 // Ensenya la carta que s'ha escollit
                    // System.out.println("S'afageix al jugador amb ordre "+i);
                    _Jugadors.get(i).afegirCarta(_mazo.get(carta));                         // Afageix la carta al jugador i
                    _mazo.remove(carta);                                                    // Treu-la del mazo de cartes disponibles
                    nCartes++;                                                              // Numero de cartes repartides al jugador i =+ 1
                }
            }
        /*PROBLEMES: No s'hi fixa en les limitacions de la pag. 7 del PDF, cal pensar-lo.
        edit: al moodle hi ha encara mes restriccions*/
        }

        private void descartarCartes () {
        // Pre: El bisbe no pot ser descartat.
        // Post: Descarta cartes de la pila sempre i quan n'hi quedi una al mazo de cartes 
        
            if (_Jugadors.size()<3) {                             // Si el numJugador és menor a 3
                eliminaCartaNom("Lladre");                        // Esborrem el Lladre
            }
            if (_Jugadors.size()<4) {                             // Si el numJugador és menor a 4
                eliminaCartaNom("Espia");                         // Esborra l'Espia
                eliminaCartaNom("Inquisidor");                    // Esborra l'Inquisidor
            }
            if (_Jugadors.size()<6) {                            // Si el numJugador és menor a 6
                // Busca el primer camperol i borra'l
                eliminaCartaNom("Camperol");
                // Busca el segon camperol i borra'l
                eliminaCartaNom("Camperol");
                // Busca el inquisidor i borra'l
                eliminaCartaNom("Inquisidor");    
            }  
                
            for (int i=1;i<_mazo.size()-1;i++){                                             // Comença des de 1 aixi no es descarta el jutge
                int aux=0;
               
                _mazo.get(i).ensenya();                                                      // Ensenya la carta que s'ha de decidir si borrar'la
                System.out.println("Decideix el jugador " + _ordre.get(aux));                // Pregunta al jugador aux
                boolean decisio=_Jugadors.get(_ordre.get(aux)).decidir();                   // Formula pregunta de SI (TRUE) o NO (FALSE)
               
                aux++;
                while (aux<_ordre.size() && decisio) {                                      // Mentres decisió de borrar la carta és que si i has preguntat a tots els jocs
                     System.out.println("Decideix el jugador " + _ordre.get(aux));
                     decisio=_Jugadors.get(_ordre.get(aux)).decidir();                      // Torna a demanar si si o no
                     aux++;
                }
                if (decisio)                                                                // Si tothom ha decidit descartar-la, descartem la carta
                {
                    boolean camperol = _mazo.get(i).getNom().equals("Camperol");            // Si la carta que es vol borrar es Camperol, camperol = true
                    _mazo.remove(i);                                                         // Borra la carta del mazo de cartes no descartades i que no te cap jugador
                    _rolsDisp.remove(i);                                                     // Borra la carta dels rols disponibles
                    if(camperol)                                                             // Si s'ha decidit borrar el camperol
                        eliminaCartaNom("Camperol");                                         // Borra l'altre camperol
                    i--;
                } 
                System.out.println("");
            }
        }
        
        
        public void pagarMulta() {
        //Pre: --
        //Post: Afegeix una moneda al palau de justícia i resta'n una al/s jugador/s mentider/s.
        
            _monedesJusticia.afegirMonedes(1);                                              // Afegeix una moneda al Palau de Justicia
            //_Jugadors.get(_ordre.get(_jugadorActual)).pagarMulta();
        }
        
        
        
        public void interrupcions(Rol rol) {
             // Pre: --
             // Post: els jugadorsque interrompen mentiders paguen la multa, al que diu la veritat se li guarda l'index a _indexExecutador.
            
            Interrupcio intr = new Interrupcio();
            intr.preguntarInterrupcio(this); // li passem la partida actual com a parametre
            
            if (intr.numInterrupcions()!=1) {
                while (intr.hiHaInterrupcions()) {
                    int index=intr.getIndex(); // retornem un index i alhora l'esborrem del vector d'interrupcions.
                    if (_Jugadors.get(index).getCartaActual().getRolCarta().equals(rol)) { // falta implementar la part d'escollir la carta que vol mostrar.
                    _indexExecutador=index;
                    }
                    else  {
                        _Jugadors.get(index).pagarMulta();
                        _monedesJusticia.afegirMonedes(1);
                    }
                }
            }
            else intr.buidaVectorIntr();
        }
                     
        public void actualitzaIndexJugador(){
        // Pre: --
        // Post: Actualitza el valor de indexExecutar segons el ordre del jugador que toqui
        
            _indexExecutador = _ordre.get(_indexOrdre);
        }
        
        public void incrementaOrdre(){
        // Pre: --
        // Post: Incrementa indexOrdre
        
            _indexOrdre++;
            if(_indexOrdre > _ordre.size()){
                _indexOrdre = 0;
            }
        }
       
         
        public void setRolJugador(Rol r, int i){
        // Pre: Rol r és un rol di
        // Post:
            
            _Jugadors.get(i).nouRol(r);
        }
        
        public void dinamicaDelJoc(){
        // Pre: --
        // Post: Estableix la dinamica del joc fins que la partida s'acabi
        
            _indexOrdre= 0;
            boolean partidaAcabada= false;
            PartidaSettings(4);
            descartarCartes();
            repartirCartes();
            
            System.out.println("");
            System.out.println("Aquest es el resultat");
            mostrarCartesPerJugadors();
            System.out.println("");
            
            
            boolean acabar = false;
            while (!acabar){
                actualitzaIndexJugador();
                // Rei, Reina, Bisbe, Bruixa, Widow, Lladre, Trampos, Buffo, Camperol, Espia, Inquisidor,                    
                    System.out.println("");
                    System.out.println("Ara juga el jugador "+_indexExecutador);
                    int accio = triarAccio();
                    if (accio == 1){
                        // Escollir carta
                        _Jugadors.get(_indexExecutador).escollirCarta();                           // En aquesta accio es guarda l'index de carta actual.
                        System.out.println("Escull un rol dels disponibles");
                        for (int q=0; q<_rolsDisp.size(); q++){
                             _rolsDisp.get(q).ensenya();
                        }
                        Rol juga = escollirRol();
                        System.out.println("");
                        interrupcions(juga);
                        _Jugadors.get(_indexExecutador).nouRol(juga);
                        _Jugadors.get(_indexExecutador).accioDeRol(this);
                        incrementaOrdre();
                    }
                    else if (accio == 2){
                        
                    }
                    else {
                        
                    }
                    System.out.println();
                    System.out.println("============================================================");
                    // En aquest punt comprova les estadístiques dels jugadors
                    System.out.println("Estadístiques dels jugadors");
                    for (int j=0; j < _Jugadors.size(); j++){
                        _Jugadors.get(_ordre.get(j)).mostraEstadistiques(_ordre.get(j));
                    }

                    // En aquest punt mostra el capital del palau i del banc
                    System.out.println("Aquest es el capital del Banc Nacional: "+_monedesBanc.retornaQuantitat());
                    System.out.println("Aquest es el capital del Palau de Justicia: "+_monedesJusticia.retornaQuantitat());
                    System.out.println("===========================================================");
                    System.out.println();
                }         
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
        
        
        //metode del gilipolles ja que mai se li acaben les monedes, pero per si de cas el deixo
        public void treureMonedesBanc(int n){
        // Pre: n > 0
        // Post: monedesdelbanc -+ n
            _monedesBanc.afegirMonedes(-n);
        }
        


        public void afegirMonedesJugador(int nJugador, int nMonedes){
        // Pre: nJugador >= 0 (nJugador representa l'índex de _nJugadors)
        // Post: 
            _Jugadors.get(nJugador).afegirMonedes(nMonedes);
        }
       
        
        public void descobrirCarta(int indexJugador, int indexCarta){
        // Pre: indexJugador >= 0 && indexJugador < numJugadors / indexCarta >=0 indexCarta < numCartesJugador
        // Post: Retorna la carta indicada per indexCarta del _Jugador[indexJugador]
            _Jugadors.get(indexJugador).ensenyarCarta(indexCarta);
        }
        
        public void intercanviarCartes(int indexJugador1, int indexCartaJugador1, int indexJugador2, int indexCartaJugador2){
        /**
         * PRE: tots els index >= 0. Els indexos jugador han de ser < _Jugador.size().
         * Els indexos de carta han de ser < _nCartesPerJugador
         * POST: Intercanvia les cartes entre el jugador1 i jugador2 (carta1 <--> carta2).
         */
            // Copies les cartes abans de fer res
            Carta aux1= _Jugadors.get(indexJugador1).getCarta(indexCartaJugador1);
            Carta aux2= _Jugadors.get(indexJugador2).getCarta(indexCartaJugador2);
            
            // Esborrar cartes corresponents
            _Jugadors.get(indexJugador1).esborrarCarta(indexCartaJugador1);
            _Jugadors.get(indexJugador2).esborrarCarta(indexCartaJugador2);
            
            // Afegir cartes copiades
            _Jugadors.get(indexJugador1).afegirCarta(aux2);
            _Jugadors.get(indexJugador1).afegirCarta(aux1);
            
        }
        
        public void fiPartidaTrampos(int nouLimit){
        // Pre: noulimit < _monedesPerGuanyar && noulimit > 0
        // Post: _fiPartida = true si el Jugador trampos ha superat el limit que imposa el seu rol
            _fiPartida = nouLimit<=_Jugadors.get(_indexExecutador).retornaMonedes().retornaQuantitat();//es pot fer amb Moneda per polirlo millor
        }
        

        /*
        SUGERENCIA: per fer lo de les queixes recomano fer un 'for' per a tots els jugadors
        (menys el que jugador actual obviament) i anar preguntant si es queixen (decisio). Si
        es queixen --> agregar a un vector de interrupcions.
        */
}
