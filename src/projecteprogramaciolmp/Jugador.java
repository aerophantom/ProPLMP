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
    Moneda _monedes;                                                            // Monedes de les que disposa el jugador
    private int _cartaActual;                                                   // Carta que el Jugador utilitza en el torn
    private ArrayList<Carta> _cartesJugador;                                    //Array amb les cartes de les que disposa el jugador
    Accio _accion;                                                              //Accio de la que disposa el jugador
    // --------------------
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Jugador(){/**
     * PRE:--
     * POST: No te monedes, la carta actual es la primera de l'array, l'accio es
     * la de defecte i es disposa d'un array de 3 cartes.
     */
        _monedes= new Moneda();
        _cartaActual=0;
        _accion = new Accio();
        _cartesJugador = new ArrayList<> (3);
    }
    
    public Jugador(int monedes){/**
     * PRE: monedes >= 0
     * POST: Te <monedes> monedes, la carta actual es la primera de l'array, l'accio es
     * la de defecte i es disposa d'un array de 3 cartes.
     */
        _accion= new Accio();
        _monedes= new Moneda(monedes);
        _cartesJugador = new ArrayList<> (3);
        _cartaActual = 0;
    }
    public Rol getRolActual(){/**
     * PRE:--
     * POST: Retorna el rol actual del jugador.
     */
        return _accion.getRol();
    }
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
     
     
    public Carta getCartaActual() {/**
      * PRE:--
      * POST: Retorna la carta actual.
      */
        return _cartesJugador.get(_cartaActual);
    }
    
    public void mostraEstadistiques(int j){
        System.out.println("Les monedes del jugador "+j+" són: "+_monedes.retornaQuantitat());
         /*
         for(int i=0; i < _cartesJugador.size(); i++){
             _cartesJugador.get(i).ensenya();
         }
        */
    }
     
    public Carta getCarta(int indexCarta){/**
      * PRE: 0 <= indexCarta < cartesJugador.size()
      * POST: Retorna la carta corresponent al <indexCarta>.
      */
        return _cartesJugador.get(indexCarta);
    }
    public Moneda retornaMonedes(){/**
        * PRE:--
        * POST: Retorna el contenidor de monedes que te el jugador
        */
        return _monedes;
    }
    public int nCartes(){/** ¿¿¿CAL AQUEST METODE???
    * PRE:--
    * POST: Retorna quantes cartes té el jugador
    */            
       return _cartesJugador.size();
    }
    public boolean decidir(){/**
     * PRE:--
     * POST: retorna un valor boolea segons l'accio decidir feta pel jugador.
     */
       return _accion.decidir();
    }
    public void consultarCarta() {/**
     * PRE:--
     * POST: S'executa l'acció de consultar carta sobre aquest jugador.
     */
        _accion.consultaCarta(this);

    }
    public void ensenyaCartes(){
        for(int i=0; i<_cartesJugador.size(); i++){
            _cartesJugador.get(i).ensenya();
        }
    }
    public void ensenyarCarta(int indexCarta){
        _cartesJugador.get(indexCarta).mostrarCarta();
    }
    // ============================================================
    // Mètodes MODIFICADORS
    // ============================================================
       
    public void afegirMonedes (int mon) {
    // Pre: mon >=0 mon <=0
    // Post: Realitza la operació _monedes + mon
         _monedes.afegirMonedes(mon);
    }


    public void esborrarCarta(int nCarta){/**
     * PRE: 0 <= nCarta < cartesJugador.size()
     * POST: Esborra la carta corresponent al index <nCarta>.
     */
        _cartesJugador.remove(nCarta);
    }
    public void afegirCarta(Carta nova){/**
     * PRE: <nova> instanciada
     * POST: Afegeix <nova> al vector de cartes del jugador.
     */
        _cartesJugador.add(nova);
    }
    public void escollirCarta() {

        System.out.println("Escull una carta");
        for (int i=0;i<_cartesJugador.size();i++) {
            System.out.println("Carta " + i);
        }
        Scanner teclat= new Scanner(System.in);
        int carta = teclat.nextInt();
        while (carta<0 || carta>_cartesJugador.size()-1){
              System.out.println();
              System.out.println("Has entrat un número de carta invàlida. Torna a escollir siusplau");
           // for (int i=0;i<_cartesJugador.size();i++) {
           //   System.out.println("Carta " + i);
           // }
           // carta = teclat.nextInt();
      //  }
        _cartaActual = carta;
        // falta implementar el codi de triar la carta, basicament donar valor a _cartaJugada

         }
    }
    
    public void accioDeRol(Partida p){/**
     * PRE: <p> setejat.
     * POST: S'executa l'accio de rol.
     */
        _accion.accioDeRol(p);
    }

    public void nouRol (Rol r){/**
     * PRE: <r> instanciat.
     * POST: El rol actual ara es <r>.
     */
        _accion.nouRol(r);
    }
}
