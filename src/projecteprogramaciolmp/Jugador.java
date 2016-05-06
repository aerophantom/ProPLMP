/////////////////////////////////
///
///  Resoldre com cullons va el rol i el jugador i la carta
///  ¿ Com fer que per exemple en l'acció de rol del Rei, resti 3 monedes del Banc Nacional i les sumi al Rei ?
///
////////////////////////////////
package projecteprogramaciolmp;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class Jugador {
    
    // Atributs
    // --------------------
        Moneda _monedes; // Monedes de les que disposa el jugador
        private int _cartaActual; // Carta que el Jugador utilitza en el torn
        private ArrayList<Carta> _cartesJugador;
        Accio _accion;
    // --------------------
    
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              CONSTRUCTORS                                                         //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Jugador(){
    // Pre: --
    // Pos: No té monedes, la carta actual és la primera de l'array, l'acció es la del constructor per defecte 
    // i es disposa d'un array de 3 cartes
        _monedes= new Moneda();
        _cartaActual=0;
        _accion = new Accio();
        _cartesJugador = new ArrayList<> (3);
    }
    
    public Jugador(int monedes){
    // Pre: monedes >= 0
    // Post: Té nmonedes, la carta actual és la primera de l'array, l'acció és la de defecte del constructor 
    // i es disposa un array de 3 cartes (maxim per 2 jugadors)
        _accion= new Accio();
        _monedes= new Moneda(monedes);
        _cartesJugador = new ArrayList<> (3);
        _cartaActual = 0;
    }

    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES CONSULTORS                                                   //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
     
    public Rol getRolActual(){
    // Pre: --
    // Post: Retorna el rol actual del jugador
        return _accion.getRol();
    }
     
    public Carta getCartaActual() {
    // Pre: --
    // Post: Retorna la carta actual
        return _cartesJugador.get(_cartaActual);
    }
    
    public void mostraEstadistiques(int j){
    // Pre: j correspon a un número de jugador
    // Post: Ensenya les monedes del jugador i les seves cartes
        System.out.println("Les monedes del jugador "+j+" són: "+_monedes.retornaQuantitat());
        ensenyaCartes();
    }
     
    public Carta getCarta(int indexCarta){
    // Pre: indexCarta >= 0 && indexCarta < cartesJugador.size()
    // Post: Retorna la carta corresponent a indexCarta
        return _cartesJugador.get(indexCarta);
    }
    
    public Moneda retornaMonedes(){
    // Pre: --
    // Post: Retorna el l'objecte monedes del jugador
        return _monedes;
    }
    
    public int nCartes(){
    // Pre: --
    // Post: Retorna num de cartes que té el jugador       
       return _cartesJugador.size();
    }
    
    public boolean decidir(){
    // Pre: --
    // Post: Retorna un boolea segons l'acció que ha decidit el jugador -> TRUE si SI FALSE si NO
       return _accion.decidir();
    }
    
    public void consultarCarta() {
     // Pre: --
     // Post: S'executa l'acció de consultar carta sobre aquest jugador
        _accion.consultaCarta(this);
    }
    
    public void ensenyaCartes(){
    // Pre: --
    // Post: Ensenya les cartes que té el jugador
        for(int i=0; i<_cartesJugador.size(); i++){
            ensenyarCarta(i);
        }
    }
    
    public void ensenyarCarta(int indexCarta){
    // Pre indexCarta >= 0 && indexCarta <= _cartes.size()
    // Post: Ensenya la carta marcada per indexCarta dins el vector de cartes
        _cartesJugador.get(indexCarta).mostrarCarta();
    }

    public int getIndCartaActual(){
    // Pre:
    // Post:
        return _cartaActual;
    }
        
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES MODIFICADORS                                                 //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
   
       
    public void borraCarta(){
    // Pre: --
    // Post: Borra la carta assenyalada per _cartaActual dins el array de cartes 
        _cartesJugador.remove(_cartaActual);
    }
    
    public void afegirMonedes (int mon) {
    // Pre: mon >=0 mon <=0
    // Post: Realitza la operació _monedes + mon
         _monedes.afegirMonedes(mon);
    }


    public void esborrarCarta(int nCarta){
    // Pre: 0 <= nCarta < cartesJugador.size()
    // Post: Esborra la carta corresponent al index nCarta
        _cartesJugador.remove(nCarta);
    }
    
    public void afegirCarta(Carta nova){
    // Pre: nova instanciada
    // Post: Afegeix nova al vector de cartes del jugador
        _cartesJugador.add(nova);
    }
    
    public void escollirCarta() {
    // Pre: --
    // Post: Mostra les cartes del jugador i escolleix-ne una per guardar-la com a _cartaActual (carta que es jugarà en cas que ho necessiti en el seu torn)
        if (_cartesJugador.size() > 1){
            System.out.println("Escull una carta");
            for (int i=0;i<_cartesJugador.size();i++) {
                System.out.println("Carta " + i);
            }
            Scanner teclat= new Scanner(System.in);
            int carta = teclat.nextInt();                                                                 // Entra un enter referent al número de carta
            while (carta<0 || carta>_cartesJugador.size()-1){
                  System.out.println();
                  System.out.println("Has entrat un número de carta invàlida. Torna a escollir siusplau");
                  for (int i=0;i<_cartesJugador.size();i++) {
                      System.out.println("Carta " + i);
                  }
                  carta = teclat.nextInt();
            }
            _cartaActual = carta;
        }
        else _cartaActual = 0;
    }
    
    
    public void accioDeRol(Partida p){
    // Pre: p setejat
    // Post: S'executa l'acció de rol
        _accion.accioDeRol(p);
    }

    public void nouRol (Rol r){
    // Pre: r instanciat
    // Post: El rol actual ara es r
        _accion.nouRol(r);
    }
    
} // END OF CLASS JUGADOR
