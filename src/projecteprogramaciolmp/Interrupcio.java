/* DESCRIPCIO
 * Classe que controla les interrupcions (o protestes) de la classe <Partida>
 */
package projecteprogramaciolmp;

import java.util.ArrayList;
import java.util.Arrays;

public class Interrupcio {

    // ATRIBUTS
    // --------------------------------------------------------
    private ArrayList<Integer> _vectorInterrupcions;
    // --------------------------------------------------------
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              CONSTRUCTORS                                                         //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public Interrupcio() {
    // Pre: --
    // Post: Crea el array _vectorInterrupcions
        _vectorInterrupcions= new ArrayList<> ();
    }
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES CONSULTORS                                                   //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    public boolean hiHaInterrupcions(){
    // Pre: --
    // Post: Retorna TRUE si algu s'ha queixat de ser mentider el executador
        return !_vectorInterrupcions.isEmpty();
    }
    
    public int numInterrupcions() {
    // Pre: --
    // Post: Retorna el num de Jugadors que s'han queixat
        return _vectorInterrupcions.size();
    }
    
    public int getIndex() {
    // Pre: --
    // Post: Retorna l'índex del primer jugador que s'ha queixat i esborra'l del vector d'interrupcions
        int i=_vectorInterrupcions.get(0);                      // Obté index del jugador del primer vector interrupcions
        _vectorInterrupcions.remove(0);                         // Borra'l del vector d'interrupcions
        return i;
    }       
    
////// ================================================================================================================= //////
//////                                                                                                                   //////
//////                                              MÈTODES MODIFICADORS                                                 //////
//////                                                                                                                   //////
////// ================================================================================================================= //////
    
    
    public void buidaVectorIntr() {
        // Pre: --
        // Post: Esborra l'unic jugador que hi ha a _vectorInterrupcions.
        _vectorInterrupcions.remove(0);
    }
    
    public void preguntarInterrupcio(Partida p) {
    // Pre: p setejat
    // Post: Pregunta a tots els jugadors de p si vol interrompre. En cas 
    // que i jugador protesti,es guardarà el seu index al vectorInterrupcio automaticament es guarda (sense preguntar) el jugador que té el torn
        boolean volInterrompre=false;
        for (int i=0;i<p.getNumJugadors();i++) {        // Recorrer tots els jugadors
            if (i!=p.obtIndexJugadorExecutador()){      // Mentres el jugador no sigui el executador de l'accio de rol
               System.out.println("Jugador " + i);
               System.out.println("Vols interrompre?");
               volInterrompre=p.preguntarJugador(i);    // Recull la resposta
                
                if (volInterrompre) {                   // Si vol interrompre
                    _vectorInterrupcions.add(i);        // afegeix-lo
                }
             }
            else  _vectorInterrupcions.add(i);          // El executador de la interrupcio també ha de entrar al vector. Pot ser que menteixi
        } 
    }
    
} // END OF CLASS INTERRUPCIO
